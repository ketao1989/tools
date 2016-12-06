package io.github.ketao1989.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author: tao.ke Date: 2016/12/4 Time: 下午7:13
 * @version: \$Id$
 */
public class RmiServer {

    public static void main(String[] args) {
        try {
            RmiService service = new RmiServiceImpl();
            LocateRegistry.createRegistry(9999);
            Naming.rebind("rmi://127.0.0.1:9999/service1",service);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("-----------------------------");
    }

}
