package io.github.ketao1989.serial;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author: zinian Date: 2016/12/6 Time: 下午10:53
 * @version: \$Id$
 */
public class KryoSerializable {

    public static void serial(Blog blog)throws Exception{
        Kryo kryo = new Kryo();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Output output = new Output(baos);
        kryo.writeClassAndObject(output, blog);
        output.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        Input input = new Input(bais);
        Blog blog1 = (Blog) kryo.readClassAndObject(input);
        input.close();
        System.out.println(blog1);
    }
}
