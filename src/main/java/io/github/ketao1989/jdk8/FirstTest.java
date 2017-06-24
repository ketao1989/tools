package io.github.ketao1989.jdk8;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import io.github.ketao1989.jackson.TypeB;

/**
 * @author tao.ke Date: 2017/6/3 Time: 下午10:29
 */
public class FirstTest {

    public static void main(String[] args) {

        List<String> list = Lists.newArrayList("a", "b", "c", "f", "d");
        list.sort(Comparator.comparing((a) -> a.charAt(0), FirstTest::myCompare));
        System.out.println(list);

        // stream
        List<String> others = list.stream().filter((a) -> !a.equals("c")).collect(Collectors.toList());
        System.out.println(others);

        others.forEach(System.out::println);

        String a = "test123";
        System.out.println(a.split("").length);

        TypeB b1 = new TypeB("jiangxi",1001);
        TypeB b2 = new TypeB("zhejiang",1002);
        TypeB b3 = new TypeB("beijing",1003);

        List<TypeB> bs = Lists.newArrayList(b1,b2,b3);

        System.out.println(bs.stream().collect(listToMap((entry) -> entry.getCode())));;

    }

    public static int myCompare(Character c1, Character c2) {

        switch (c1) {

        case 'c':
            System.out.println("here is c character");
        default:
            return c2.compareTo(c1);
        }
    }

    public static <T, K> Collector<T, ?, Map<K, T>> listToMap(Function<? super T, ? extends K> classifier) {

        Supplier<Map<K, T>> supplier = HashMap::new;
        BiConsumer<Map<K, T>, T> accumulator = (m, t) -> {
            m.put(classifier.apply(t), t);
        };

        BinaryOperator<Map<K, T>> combiner = (left, right) -> { left.putAll(right); return left; };

        return Collector.of(supplier,accumulator,combiner,Collector.Characteristics.UNORDERED);

    }
}
