package io.github.ketao1989.jackson;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by ketao on 15-2-10.
 */
public class JsonDeserializeTest {

    public static void main(String[] args) {

        String jsonString = "{\"name\":\"kexiaoxiaoxi\",\"age\":19,\"hobby\":[\"MacOsTestSerialize\",\"LinuxTestSerialize\",\"WindowsTestSerialize\",\"UnknownTestSerialize\"],\"b\":\"TypeB{address='beijing', code=100000}\"}";

        ClassA a = JsonUtils.decode(jsonString, ClassA.class);

        System.out.println(a.getB());
        System.out.println(a);

        System.out.println("--------------------------");


        List<TypeB> b = Lists.newArrayList(new TypeB("jiangxi", 320000), new TypeB("beijing", 100000));

        String bJsonStr = JsonUtils.encode(b);

        List<TypeB> bb = JsonUtils.decode(bJsonStr, List.class);
        System.out.println(bb);

//        List<TypeB> bc = JsonUtils.decode(bJsonStr, new ParameterizedTypeReference<List>() {
//        });
//        System.out.println(bc);
    }
}
