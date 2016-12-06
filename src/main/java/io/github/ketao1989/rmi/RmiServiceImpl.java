package io.github.ketao1989.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author: tao.ke Date: 2016/12/4 Time: 下午7:10
 * @version: \$Id$
 */
public class RmiServiceImpl extends UnicastRemoteObject implements RmiService {

    public RmiServiceImpl() throws RemoteException {
    }

    public String hello(String name) throws RemoteException {
        return "Hello " + name;
    }
}
