/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.file;

import java.io.RandomAccessFile;

/**
 * @author tao.ke Date: 15/12/13 Time: 下午6:04
 */
public class ReadFileAppend {

    public static void main(String[] args) throws Exception {

        RandomAccessFile randomAccessFile = new RandomAccessFile("test.txt","r");

        String line = null;
        while (true){
            if ((line =randomAccessFile.readLine()) != null){
                System.out.println(line);
            }
        }
    }

}
