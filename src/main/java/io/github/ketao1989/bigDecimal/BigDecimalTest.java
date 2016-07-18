/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.bigDecimal;

import java.math.BigDecimal;

/**
 * @author tao.ke Date: 16/7/18 Time: 下午2:00
 */
public class BigDecimalTest {

    public static void main(String[] args) {

        // BigDecimal 将小数,转换成数字数组类型结构(数字数组 + 小数点后有几位数字),然后转换long类型,匹配两个数位数
        // 保证 两者乘以相同的10,然后为整形,进行普通操作;然后输出字符串的时候,把小数点 放到对应的输出位置
        BigDecimal a = new BigDecimal("231.41");
        BigDecimal b = new BigDecimal("0.412");

        BigDecimal c = a.add(b);

        System.out.println(c.toString());

    }
}
