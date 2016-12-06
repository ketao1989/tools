package io.github.ketao1989.rpc;

/**
 * @author: tao.ke Date: 2016/12/5 Time: 下午9:54
 * @version: \$Id$
 */
public class ClientDemo {

    public static void main(String[] args) {
        System.out.println("----------start invoke----------------");
        RpcService service = ServiceProxyClient.getInstance(RpcService.class);
        System.out.println(service.sayHi("RPC World"));
        System.out.println("----------end invoke----------------");
    }
}
