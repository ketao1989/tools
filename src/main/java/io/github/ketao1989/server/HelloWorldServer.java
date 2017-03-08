package io.github.ketao1989.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author: zinian Date: 2017/3/5 Time: 下午5:12
 * @version: \$Id$
 * @date 2017/03/05
 */
public class HelloWorldServer {

    public static void main(String[] args) {
        HelloWorldServer server = new HelloWorldServer();
        server.startServer(8080);
    }

    public void startServer(int port) {

        try {
            //创建serverSocket来监听port
            ServerSocket serverSocket = new ServerSocket(port, 1);
            while (true) {

                // 建立一个socket连接
                Socket socket = serverSocket.accept();
                System.out.println("new connect......");

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
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
