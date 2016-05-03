/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.thrift.server;

import io.github.ketao1989.thrift.Hello;
import io.github.ketao1989.thrift.impl.HelloService;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;

/**
 * @author: ketao Date: 15-8-4 Time: 下午9:07
 * @version: \$Id\$
 */
public class NonblockThriftServer {

    private void start(){
        try {
            TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(8088);
            Hello.Processor processor = new Hello.Processor<HelloService>(new HelloService());

            TServer server = new TNonblockingServer(new TNonblockingServer.Args(serverTransport).processor(processor));

            server.serve();

        }catch (Exception e){

            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        NonblockThriftServer server = new NonblockThriftServer();
        server.start();
    }
}
