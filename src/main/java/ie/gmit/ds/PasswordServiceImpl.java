package ie.gmit.ds;

import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

/**
 * The service implementation of the gRPC password service where all the methods implements.
 */
public class PasswordServiceImpl extends PasswordServiceGrpc.PasswordServiceImplBase {
    private static final Logger logger = Logger.getLogger(PasswordServiceImpl.class.getName());

    /**
     * Take response from client and hash password with salt together.
     *
     * @param request          request from client.
     * @param responseObserver observer.
     */
    @Override
    public void hash(PasswordRequest request, StreamObserver<PasswordResponse> responseObserver) {
        logger.info("Hashing password...");

        byte[] salt = Passwords.getNextSalt();
        byte[] hash = Passwords.hash(request.getPassword().toCharArray(), salt);

        // logger.info("uid: " + request.getUserId() + " pw: " + request.getPassword() + " hash: " + hash);  // debug purpose

        PasswordResponse pr = PasswordResponse.newBuilder()
                .setUserId(request.getUserId())
                .setHashedPassword(ByteString.copyFrom(hash))
                .setSalt(ByteString.copyFrom(salt))
                .build();

        responseObserver.onNext(pr);
        responseObserver.onCompleted();

        logger.info("Hash password complete!");
    }

    /**
     * Take response from client and check if the password from client matches the hashed password
     *
     * @param request          request from client
     * @param responseObserver observer
     */
    @Override
    public void validate(ValidatePassword request, StreamObserver<BoolValue> responseObserver) {
        logger.info("Validating password...");

        // logger.info("pw: " + request.getPassword());  // debug purpose

        boolean isValid = Passwords.isExpectedPassword(
                request.getPassword().toCharArray(),
                request.getSalt().toByteArray(),
                request.getHashedPassword().toByteArray()
        );

        BoolValue res = BoolValue.newBuilder()
                .setValue(isValid)
                .build();

        responseObserver.onNext(res);
        responseObserver.onCompleted();

        String msg = (isValid) ? "VALID" : "INVALID";
        logger.info(msg);
    }
}
