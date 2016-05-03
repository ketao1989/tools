/*
 * Copyright (c) 2014 Qunar.com. All Rights Reserved.
 */
package test;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author tao.ke Date: 15-3-11 Time: 下午10:10
 * @version \$Id$
 */
public class EnumSetTest {

    public static void main(String[] args) {

        Set<OrderStatus> statuses = EnumSet.noneOf(OrderStatus.class);
        statuses.add(OrderStatus.CONFIRM_ORDER);
        statuses.add(OrderStatus.INIT_ORDER);
        statuses.add(OrderStatus.NEW_ORDER);
        statuses.add(OrderStatus.CONFIRM_ORDER);
        System.out.println(statuses);

        statuses.remove(OrderStatus.CONFIRM_ORDER);
        System.out.println(statuses);

        if (statuses.contains(OrderStatus.NEW_ORDER)){
            System.out.println("----====-----");
        }
    }

}
