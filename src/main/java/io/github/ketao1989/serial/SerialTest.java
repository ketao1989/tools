package io.github.ketao1989.serial;

import com.alibaba.dubbo.common.serialize.ObjectInput;
import com.alibaba.dubbo.common.serialize.ObjectOutput;
import com.alibaba.dubbo.common.serialize.support.hessian.Hessian2Serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author: zinian Date: 2016/12/6 Time: 下午9:48
 * @version: \$Id$
 */
public class SerialTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Blog blog = new Blog("11111","rpc serial");
        blog.setContent("content.");
        //blog.setId(11111L);
        blog.setCreateTime(new Timestamp(System.currentTimeMillis()));




        try {

            //HessianSerialibale.serial(blog);
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



        ByteArrayOutputStream bos = new ByteArrayOutputStream(512);
        Hessian2Serialization hessian2Serialization = new Hessian2Serialization();

        ObjectOutput output = hessian2Serialization.serialize(null, bos);
        output.writeObject(blog);
        output.flushBuffer();


        ByteArrayInputStream inputStream = new ByteArrayInputStream(bos.toByteArray());
        ObjectInput input = hessian2Serialization.deserialize(null, inputStream);
        BlogOth res  = input.readObject(BlogOth.class);

        System.out.println(res);

    }
}
