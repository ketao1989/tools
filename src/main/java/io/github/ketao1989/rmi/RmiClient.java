package io.github.ketao1989.rmi;

import java.rmi.Naming;

/**
 * @author: tao.ke Date: 2016/12/4 Time: 下午7:17
 * @version: \$Id$
 */
public class RmiClient {
    public static void main(String[] args) {
        try {
            RmiService service = (RmiService)Naming.lookup("rmi://localhost:9999/service1");
            System.out.println(service.hello("RMI"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
