package ie.gmit.ds;

import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordClient {
    private static final Logger logger = Logger.getLogger(PasswordClient.class.getName());
    private final ManagedChannel channel;
    private final PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService;

    public PasswordClient(String host, int port) {
        channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();
        syncPasswordService = PasswordServiceGrpc.newBlockingStub(channel);
        logger.info("Successfully connected to server!");
    }

    public PasswordResponse sendPassword(int uid, String password) {
        logger.info("Trying to send UserID: " + uid + " and Password: " + password);

        PasswordRequest req = PasswordRequest.newBuilder()
                .setUserId(uid)
                .setPassword(password)
                .build();

        PasswordResponse res;

        try {
            res = syncPasswordService.hash(req);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return null;
        }

        logger.info("Password hashed: " + res.getHashedPassword());
        return res;
    }

    public void validatePassword(String password, ByteString salt, ByteString hash) {
        logger.info("Validating password: " + password + ", salt: " + salt + " and hash: ");

        ValidatePassword req = ValidatePassword.newBuilder()
                .setPassword(password)
                .setSalt(salt)
                .setHashedPassword(hash)
                .build();

        BoolValue res;

        try{
            res = syncPasswordService.validate(req);
        } catch (StatusRuntimeException e){
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }

        String msg = (res.getValue()) ? "Correct" : "Failed";

        logger.info(msg);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws Exception {
        PasswordClient client = new PasswordClient("localhost", 50551);
        int userID = 123;
        String password = "BernardG00341962";

        try{
            PasswordResponse res = client.sendPassword(userID, password);
            client.validatePassword(password, res.getSalt(), res.getHashedPassword());
        } finally {
            client.shutdown();
        }
    }
}
