package io.github.ketao1989.serial;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author: zinian Date: 2016/12/6 Time: 下午9:31
 * @version: \$Id$
 */
public class JdkSerialiable {
    public static void serial(Blog blog) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(baos);
        os.writeObject(blog);
        os.close();

        ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        Blog blog1 = (Blog) is.readObject();
        is.close();
        System.out.println(blog1);
    }
}
