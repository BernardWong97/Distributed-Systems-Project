package ie.gmit.ds;

import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Client class to create a client with a userID and a password to connect the Password Server.
 */
public class PasswordClient {
    private static final Logger logger = Logger.getLogger(PasswordClient.class.getName());
    private final ManagedChannel channel;
    private final PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService;

    /**
     * Creates a channel to connect the Password Server through the service.
     *
     * @param host this current device name.
     * @param port the connecting port number.
     */
    public PasswordClient(String host, int port) {
        channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();
        syncPasswordService = PasswordServiceGrpc.newBlockingStub(channel);
        logger.info("Successfully connected to server!");
    }

    /**
     * Send UserID and Password to the service to get the password hashed.
     *
     * @param uid      user ID.
     * @param password user password.
     * @return A PasswordResponse for debugging purpose.
     */
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

        // logger.info("Password hashed: " + res.getHashedPassword()); // debug purpose
        logger.info("Send info success!");
        return res;
    }

    /**
     * Validate the password check whether it matches the hashed password or not.
     *
     * @param password user password.
     * @param salt     stored salt.
     * @param hash     hashed password.
     */
    public void validatePassword(String password, ByteString salt, ByteString hash) {
        logger.info("Validating password: " + password + ", salt: " + salt + " and hash: ");

        ValidatePassword req = ValidatePassword.newBuilder()
                .setPassword(password)
                .setSalt(salt)
                .setHashedPassword(hash)
                .build();

        BoolValue res;

        try {
            res = syncPasswordService.validate(req);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }

        String msg = (res.getValue()) ? "Correct" : "Failed";

        logger.info(msg);
    }

    /**
     * Disconnect from the server after 5 seconds.
     *
     * @throws InterruptedException
     */
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * Main method creating a client object and test if the password is correctly hashed and validate.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        PasswordClient client = new PasswordClient("localhost", 50551);
        int userID = 123;
        String password = "BernardG00341962";

        try {
            PasswordResponse res = client.sendPassword(userID, password);
            client.validatePassword(password, res.getSalt(), res.getHashedPassword());
        } finally {
            client.shutdown();
        }
    }
}
