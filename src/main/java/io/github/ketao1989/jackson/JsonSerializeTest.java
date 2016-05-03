package io.github.ketao1989.jackson;

import com.google.common.collect.Lists;

/**
 * Created by ketao on 15-2-7.
 */
public class JsonSerializeTest {

    public static void main(String[] args) {

        ClassA a = new ClassA();

        a.setAge(10);
        a.setName("ketao1989");
        a.setHobby(Lists.newArrayList("dinner","swimming","music","programming"));
        a.setB(new TypeB("jiangxi",320000));

        String aJsonStr = JsonUtils.encode(a);
        System.out.println(aJsonStr);

        ClassA aa = new ClassA();

        aa.setAge(19);
        aa.setName("kexiaoxiaoxi");
        aa.setHobby(Lists.newArrayList("MacOs", "Linux", "Windows", "Unknown"));
        aa.setB(new TypeB("beijing", 100000));

        String aaJsonStr = JsonUtils.encode(aa);
        System.out.println(aaJsonStr);


        String bb = JsonUtils.encode(new TypeB("beijing",100000));
        System.out.println(bb);

    }
}
