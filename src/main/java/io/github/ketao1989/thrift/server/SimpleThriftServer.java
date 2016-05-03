/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.thrift.server;

import io.github.ketao1989.thrift.Hello;
import io.github.ketao1989.thrift.impl.HelloService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * �������Ӧ
 *
 * @author ketao Date: 2015/7/16 Time: 11:02
 * @version \$Id$
 */
public class SimpleThriftServer {

    private static final Logger logger = LoggerFactory.getLogger(SimpleThriftServer.class);

    public  void simple(int port){

        try {
            TServerSocket tServerSocket = new TServerSocket(port);
            Hello.Processor processor = new Hello.Processor(new HelloService());

            TServer server = new TSimpleServer(new TServer.Args(tServerSocket).processor(processor) );
            server.serve();

        }catch (Exception e){
            logger.error("server start error........",e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleThriftServer server = new SimpleThriftServer();
        server.simple(8589);
    }
}
