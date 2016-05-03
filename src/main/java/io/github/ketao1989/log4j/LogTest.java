/*
 * Copyright (c) 2014 Qunar.com. All Rights Reserved.
 */
package io.github.ketao1989.log4j;

import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

/**
 * @author: ketao Date: 14-5-3 Time: 上午1:03
 * @version: \$Id: LogTest.java 6 2014-05-24 14:13:48Z ketao1989 $
 */
public class LogTest {
    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static int trailingZeroes(int n) {
        int count = 0;
        while(n>=5){
            count = count + n/5;
            n = n/5;
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(1<<1);

        int a = Integer.MIN_VALUE;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(-a));


        FastDateFormat dateFormat = FastDateFormat.getInstance("MM-dd");
        System.out.println(dateFormat.format(0));

        System.out.println(trailingZeroes(100));

        int b = -536870910;
        //int a = (1 << 29) -1;
        System.out.println(Integer.toBinaryString(b&a));

        System.out.println(TimeUnit.MILLISECONDS.convert(1,TimeUnit.DAYS));

        MDC.put("THREAD_ID", String.valueOf(Thread.currentThread().getId())+ Thread.currentThread().getName());


        logger.debug("-----=======-------=====--------");

        logger.info("纯字符串信息的info级别日志");
        logger.info("一个参数:{}的info级别日志", "agr1");
        logger.info("二个参数:agrs1:{};agrs2:{}的info级别日志", "args1", "args2");
        // 下面两种方式都可以，一般使用上面一种就可以了
        logger.info("三个参数:agrs1:{};agrs2:{};args3:{} 的info级别日志", "args1", "args2", "args3");
        logger.info("三个参数:agrs1:{};agrs2:{};args3:{} 的info级别日志", new Object[] { "args1", "args2", "args3" });

        logger.info("======================异常相关====================================");
        // 测试异常相关日志
        logger.info("抛出异常,e:", new IOException("测试抛出IO异常信息"));

        logger.info("二个参数:agrs1:{};agrs2:{}的info级别日志", "args1", new IOException("测试抛出IO异常信息"));
        logger.info("二个参数:agrs1:{};agrs2:{}的info级别日志", "args1", "args2", new IOException("测试抛出IO异常信息"));

        // 下面两种方式都可以，一般使用上面一种就可以了
        logger.info("三个参数:agrs1:{};agrs2:{};args3:{} 的info级别日志", "args1", "args2", new IOException("测试抛出IO异常信息"));
        logger.info("三个参数:agrs1:{};agrs2:{};args3:{} 的info级别日志", "args1", "args2", "agrs3", new IOException(
                "测试抛出IO异常信息"));

        logger.info("三个参数:agrs1:{};agrs2:{};args3:{} 的info级别日志", new Object[] { "args1", "args2", "args3",
                new IOException("测试抛出IO异常信息") });
        logger.info(MessageFormat.format("三个参数:agrs1:{0};agrs2:{1};args3: 的info级别日志", new Object[]{"args1", "args2",
                new IOException("测试抛出IO异常信息")}));


    }

}
