/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.curator;

import io.github.ketao1989.jackson.JsonUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryForever;

import java.util.List;

/**
 * @author tao.ke Date: 15/10/23 Time: 下午4:02
 * @version \$Id$
 */
public class ZkServiceTest {

    public static void main(String[] args) throws Exception {

        final CuratorFramework client = CuratorFrameworkFactory.newClient("10.10.33.134:2181", 10000, 10000, new RetryForever(1000));
        client.start();
        //client.create().creatingParentsIfNeeded().forPath("/zk/didi/test", "testS".getBytes());

       // System.out.println(new String(client.getData().forPath("/brokers/topics/blanka-trade-dev/partitions")));

        //client.setData().forPath("/zk/didi/test","test3".getBytes());
        //System.out.println(new String(client.getData().forPath("/zk/didi/test")));

        //client.create().creatingParentsIfNeeded().forPath("/zk/didi/mtest","testM".getBytes());

        client.delete().deletingChildrenIfNeeded().forPath("/zk/codis");
//        List<String> strings = client.getChildren().forPath("/brokers/topics/blanka-trade-dev/partitions");
//        for (String s :strings){
//            System.out.println(s);
//        }


//        CuratorWatcher watcher = new CuratorWatcher() {
//            public void process(WatchedEvent event) throws Exception {
//                notifyOne(client.getChildren().usingWatcher(this).forPath("/test"));
//            }
//        };
//
//        client.getChildren().usingWatcher(watcher).forPath("/test");
//

//        Thread.sleep(1000000);
        System.out.println("-----------------------");
        client.close();
    }

    private static void notifyOne(List<String> nodes){
        System.out.println(JsonUtils.encode(nodes));
    }
}
