package ie.gmit.ds;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class PasswordServer {
    private Server server;
    private static final Logger logger = Logger.getLogger(PasswordServer.class.getName());
    private static final int PORT = 50551;

    public static void main(String[] args) throws IOException, InterruptedException {
        final PasswordServer pwServer = new PasswordServer();
        pwServer.start();
        pwServer.blockUntilShutdown();
    }

    private void start() throws IOException {
        server = ServerBuilder.forPort(PORT)
                .addService(new PasswordServiceImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + PORT);

    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
