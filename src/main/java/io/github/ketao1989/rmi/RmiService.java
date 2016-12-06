package io.github.ketao1989.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 接口必须继承RMI的Remote
 *
 * @author: tao.ke Date: 2016/12/4 Time: 下午7:08
 * @version: \$Id$
 */
public interface RmiService extends Remote {

    /**
     * 必须有RemoteException，才是RMI方法
     *
     * @param name
     * @return
     * @throws RemoteException
     */
    String hello(String name) throws RemoteException;
}
