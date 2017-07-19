package io.github.ketao1989.diff;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;

import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import de.danielbechler.diff.node.Visit;

import io.github.ketao1989.jackson.ClassA;
import io.github.ketao1989.jackson.TypeB;

/**
 * 类对应文档：http://java-object-diff.readthedocs.io/en/latest/getting-started/
 *
 * @author tao.ke Date: 2017/7/17 Time: 下午5:55
 */
public class ObjectDiffTest {

    public static void main(String[] args) throws IOException {

        ClassA clazz1 = new ClassA();
        clazz1.setAge(10);
        clazz1.setB(new TypeB("jiangxi", 1001));
        clazz1.setHobby(Lists.newArrayList("jiangxi", "zhejiang", "hangzhou"));
        clazz1.setName("zhangsan");

        ClassA clazz2 = new ClassA();
        clazz2.setAge(10);
        clazz2.setB(new TypeB("jiujiang", 1001));
        clazz2.setHobby(Lists.newArrayList("jiangxi", "jiangsu", "hangzhou"));
        clazz2.setName("zhangsan1");

      DiffNode diff = ObjectDifferBuilder.buildDefault().compare(clazz2, clazz1);

        diff.visit(new DiffNode.Visitor() {

            public void node(DiffNode node, Visit visit) {
                final Object baseValue = node.canonicalGet(clazz1);
                final Object workingValue = node.canonicalGet(clazz2);

                if (baseValue instanceof List || baseValue instanceof Set || baseValue instanceof Map) {

                    final String message = node.getFieldAnnotation(PropertyCnName.class).cnName() + " changed from " + baseValue + " to " + workingValue;
                    System.out.println(message);

                } else if (!node.hasChildren() && node.isChanged()) {

                  final String message = node.getFieldAnnotation(PropertyCnName.class).cnName() + " changed from " + baseValue + " to " + workingValue;
                    System.out.println(message);
                }
            }
        });

    }

}
