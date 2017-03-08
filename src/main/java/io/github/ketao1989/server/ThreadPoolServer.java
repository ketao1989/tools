package io.github.ketao1989.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: zinian Date: 2017/3/5 Time: 下午8:43
 * @version: \$Id$
 * @date 2017/03/05
 */
public class ThreadPoolServer {

    private static final ExecutorService EXECUTOR_SERVICE = createDefaultExecutorService();

    public static void main(String[] args) {
        ThreadPoolServer server = new ThreadPoolServer();
        server.startServer(8080);
    }

    public void startServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port, 4);

            // 设置读超时无限大，保证在accept不阻塞
            serverSocket.setSoTimeout(0);

            for (; ; ) {
                Socket socket = serverSocket.accept();
                // 读超时设置无限大，保证不会断开client
                socket.setSoTimeout(0);
                try {
                    EXECUTOR_SERVICE.execute(new ProcessorRunnable(socket));
                } catch (Throwable t) {
                    t.printStackTrace();
                    socket.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ExecutorService createDefaultExecutorService() {
        SynchronousQueue<Runnable> executorQueue = new SynchronousQueue<Runnable>();
        return new ThreadPoolExecutor(8, 16, 60, TimeUnit.SECONDS, executorQueue);
    }

    public class ProcessorRunnable implements Runnable {

        private Socket socket;

        public ProcessorRunnable(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try (InputStream is = socket.getInputStream(); OutputStream os = socket.getOutputStream()) {

                // 连接成功，返回连接成功消息给客户端
                os.write(("SERVER CONN OK!" + new Date().toString() + "\n\r").getBytes(Charset.defaultCharset()));
                os.flush();

                byte[] data = new byte[16];
                int len;

                while ((len = is.read(data)) != -1) {

                    // 读取数据，将数据打印出来
                    System.out.print(new String(data, 0, len, Charset.defaultCharset()));
                    // echo反馈给客户端
                    os.write(data, 0, len);
                    os.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null && socket.isConnected()) {
                    try {
                        socket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
