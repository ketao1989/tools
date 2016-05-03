/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.rateLimiter;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.RateLimiter;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author tao.ke Date: 15/10/21 Time: 上午10:56
 * @version \$Id$
 */
public class TestRateLimiter {

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.create(1.0);

        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6);

        int i = 0;
        rateLimiter.acquire();
        System.out.println(System.currentTimeMillis()+"--------"+list.get(i++));

        TimeUnit.SECONDS.sleep(4);
        rateLimiter.acquire();
        System.out.println(System.currentTimeMillis()+"--------"+list.get(i++));
        rateLimiter.acquire();
        System.out.println(System.currentTimeMillis()+"--------"+list.get(i++));
        rateLimiter.acquire();
        System.out.println(System.currentTimeMillis()+"--------"+list.get(i++));
        rateLimiter.acquire();
        System.out.println(System.currentTimeMillis()+"--------"+list.get(i++));
        rateLimiter.acquire();
        System.out.println(System.currentTimeMillis()+"--------"+list.get(i++));

    }
}
