package ie.gmit.ds;

import com.google.protobuf.BoolValue;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class PasswordServiceImpl extends PasswordServiceGrpc.PasswordServiceImplBase {
    private static final Logger logger = Logger.getLogger(PasswordServiceImpl.class.getName());

    @Override
    public void hashPassword(PasswordRequest request, StreamObserver<PasswordResponse> responseObserver) {
        logger.info("Hashing password...");

        byte[] salt = Passwords.getNextSalt();
        byte[] hash = Passwords.hash(request.getPassword().toCharArray(), salt);

        logger.info("uname: " + request.getUserName() + " pw: " + request.getPassword() + " hash: " + hash);

        PasswordResponse pr = PasswordResponse.newBuilder()
                .setUserName(request.getUserName())
                .setHashedPassword(new String(hash))
                .setSalt(new String(salt))
                .build();

        responseObserver.onNext(pr);
        responseObserver.onCompleted();

        logger.info("Hash password complete!");
    }

    @Override
    public void validate(ValidatePassword request, StreamObserver<BoolValue> responseObserver) {
        logger.info("Validating password...");

        logger.info("pw: " + request.getPassword());

        boolean isValid = Passwords.isExpectedPassword(
                request.getPassword().toCharArray(),
                request.getSalt().getBytes(),
                request.getHashedPassword().getBytes()
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
