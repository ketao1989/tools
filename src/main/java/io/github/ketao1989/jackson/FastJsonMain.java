package io.github.ketao1989.jackson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tao.ke Date: 2017/12/28 Time: 下午4:35
 */
public class FastJsonMain {

  public static void main(String[] args) {

    List<List<String>> samples = new ArrayList<>();
    List<String> sample = new ArrayList<>();
    sample.add("a");
    sample.add("b");
    List<String> sampleOth = new ArrayList<>();
    sampleOth.add("c");
    sampleOth.add("d");
    samples.add(sample);
    samples.add(sampleOth);

    TypeReference<List<List<String>>> typeReference = new TypeReference<List<List<String>>>() {
    };

    System.out.println(samples);

    System.out.println("clazz 0 " + typeReference.getClass().getGenericSuperclass().getTypeName());

    if (typeReference.getClass().getGenericSuperclass() instanceof ParameterizedType) {

      Type
          typeHead =
          ((ParameterizedType) (typeReference.getClass().getGenericSuperclass())).getActualTypeArguments()[0];

      System.out.println("clazz 1 " + typeHead.getTypeName());

      if (typeHead instanceof ParameterizedType) {

        Type type = ((ParameterizedType) (typeHead)).getActualTypeArguments()[0];

        System.out.println("clazz 2 " + type.getTypeName());


        if (type instanceof ParameterizedType) {

          Type type1 = ((ParameterizedType) (type)).getActualTypeArguments()[0];

          System.out.println("clazz 3 " + type1.getTypeName());

          System.out.println(((ParameterizedType) (type)).getRawType().getTypeName());

//        System.out.println(((TypeVariable)type1).getGenericDeclaration());

          if (type1 instanceof ParameterizedType){

            Type type2 = ((ParameterizedType) (type1)).getActualTypeArguments()[0];

            System.out.println("clazz 4-1 " + type2.getTypeName());
          }

          if (type1 instanceof Class<?>) {

            System.out.println("class 4-2 : " + ((Class<?>) type1).getName());
          }

        }
      }


    }

    String json = JSON.toJSONString(samples);
    List<List<String>> origin = JSON.parseObject(json, new TypeReference<List<List<String>>>() {
    });

    System.out.println(origin);

  }

}
