package io.github.ketao1989.serial;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author: zinian Date: 2016/12/6 Time: 下午9:43
 * @version: \$Id$
 */
public class HessianSerialibale {

    public static void serial(Blog blog) throws Exception{

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Hessian2Output os = new Hessian2Output(baos);
        os.writeObject(blog);
        os.close();
        Hessian2Input is = new Hessian2Input(new ByteArrayInputStream(baos.toByteArray()));
        Blog blog1 = (Blog) is.readObject();
        is.close();
        System.out.println(blog1);
    }
}
