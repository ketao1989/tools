package io.github.ketao1989.rpc;

/**
 * @author: tao.ke Date: 2016/12/5 Time: 下午10:05
 * @version: \$Id$
 */
public class ServerDemo {

    public static void main(String[] args) throws Exception {

        // 发布接口
        ServiceProcessor.processor.publish(RpcService.class,new RpcServiceImpl());

        // 启动server
        ServerRemoter remoter = new ServerRemoter();
        remoter.startServer(9999);

    }
}
