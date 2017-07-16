package io.github.ketao1989.jdk8;

import java.util.stream.LongStream;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author tao.ke Date: 2017/7/6 Time: 下午4:50
 */
public class HongbaoTest {

    private static int remainTotal = 0;
    private static long remainMoney = 0L;

    private static String UPDATE_FORMAT = "update table set remain_money=%s-%s,remian_total=%s-1 where remain_total=%s";

    public static long getAndReduce() {

        // cas缓存
        while (remainTotal >= 1) {
            if (remainTotal == 1) {

                long money = remainMoney;
                // 落库
                System.out.println(String.format(UPDATE_FORMAT, remainMoney, money, remainTotal, remainTotal));
                remainMoney = 0L;
                remainTotal--;
                return money;
            }

            long money = RandomUtils.nextLong(1, remainMoney / remainTotal * 2);
            // 落库
            System.out.println(String.format(UPDATE_FORMAT, remainMoney, money, remainTotal, remainTotal));

            remainMoney -= money;
            remainTotal--;
            return money;
        }

        System.out.println("红包已抢完");
        return 0L;
    }

    /**
     * 将红包保存在cache中，包括红包参与人数和总钱数
     * 
     * @param total
     * @param money
     * @return
     */
    public static boolean initHongbao(int total, long money) {

        remainTotal = total;

        remainMoney = money;

        System.out.println(
                "insert into table(remain_total,remain_money) values(" + remainTotal + "," + remainMoney + ")");

        return true;
    }

    public static void main(String[] args) {

        initHongbao(10, 100);

        LongStream.range(1, 21L).forEach((a) -> System.out.println(getAndReduce()));

    }

}
