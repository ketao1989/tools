package io.github.ketao1989.rpc;

/**
 * @author: tao.ke Date: 2016/12/5 Time: 下午10:04
 * @version: \$Id$
 */
public class RpcServiceImpl implements RpcService {

    public String sayHi(String name) {
        return "Hello," + name;
    }
}
