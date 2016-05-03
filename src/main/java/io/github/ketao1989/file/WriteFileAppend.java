/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.file;

import org.apache.commons.lang3.RandomUtils;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Date;

/**
 * @author tao.ke Date: 15/12/13 Time: 下午7:34
 */
public class WriteFileAppend {

    public static void main(String[] args) throws Exception {
        Writer writer = new FileWriter("test.txt");

        while (true){

            writer.write("now is :"+new Date()+" "+ RandomUtils.nextInt(1,1000));
            writer.flush();
            Thread.sleep(100);
        }
    }
}
