package io.github.ketao1989.thrift.impl;

import io.github.ketao1989.thrift.Hello;
import io.github.ketao1989.thrift.HelloResult;
import org.apache.thrift.TException;

/**
 * Created by didi on 2015/7/16.
 */
public class HelloService implements Hello.Iface {

    public HelloResult sayHello(int word, int sword) throws TException {

        HelloResult result = new HelloResult();
        result.setName("test-thrift");
        //result.setAge(11);
        result.setSum(word + sword);
        System.out.println("------invoke---------");
        return result;
    }
}
