package io.github.ketao1989.rpc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: tao.ke Date: 2016/12/5 Time: 下午8:58
 * @version: \$Id$
 */
public class ServerRemoter {

    private static final ExecutorService executor =
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void startServer(int port) throws Exception {

        final ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(port));
        System.out.println("-----------start server----------------");
        try {
            while (true) {
                final Socket socket = server.accept();
                executor.execute(new MyRunnable(socket));
            }
        } finally {
            server.close();
        }
    }

    class MyRunnable implements Runnable {

        private Socket socket;

        public MyRunnable(Socket socket) {
            this.socket = socket;
        }

        public void run() {

            try (InputStream is = socket.getInputStream(); OutputStream os = socket.getOutputStream()) {

                byte[] data = new byte[10240];
                int len = is.read(data);

                ServiceProtocol.ProtocolModel model = ServiceProtocol.protocol
                    .decode(Arrays.copyOfRange(data, 0, len), ServiceProtocol.ProtocolModel.class);
                Object object = ServiceProcessor.processor.process(model);
                os.write(ServiceProtocol.protocol.encode(object));
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
