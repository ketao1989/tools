/*
 * Copyright (c) 2014 Qunar.com. All Rights Reserved.
 */
package io.github.ketao1989.processor;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author tao.ke Date: 15-3-2 Time: 下午3:11
 * @version \$Id$
 */
public class PidTest {

    public static int PID = -1;

    public static void main(String[] args) {

        if (PID < 0) {
            try {
                RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();

                String name = runtime.getName(); // format: "pid@hostname"
                PID = Integer.parseInt(name.substring(0, name.indexOf('@')));
            } catch (Throwable t) {
                PID = 0;
            }
        }

        System.out.println("current processor id is :" + PID);




    }
}
