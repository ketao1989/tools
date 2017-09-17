package io.github.ketao1989.serial;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author: zinian Date: 2016/12/6 Time: 下午9:48
 * @version: \$Id$
 */
public class SerialTest {

    public static void main(String[] args) {

        Blog blog = new Blog(1111L,"rpc serial");
        blog.setContent("this is a blog content.");
        //blog.setId(11111L);
        blog.setCreateTime(new Timestamp(System.currentTimeMillis()));




        try {

            HessianSerialibale.serial(blog);
//            long a = System.currentTimeMillis();
//            for (int i = 0;i<1;i++){
//                JdkSerialiable.serial(blog);
//            }
//            System.out.println("cost time "+ (System.currentTimeMillis() - a));
//
//            long b = System.currentTimeMillis();
//            for (int i = 0;i<1;i++){
//                HessianSerialibale.serial(blog);
//            }
//            System.out.println("cost time "+ (System.currentTimeMillis() - b));
//
//            KryoSerializable.serial(blog);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
