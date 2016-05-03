/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.classpath;

import com.google.common.collect.Sets;
import com.lmax.disruptor.EventHandler;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.Set;

/**
 * @author tao.ke Date: 15/12/14 Time: 下午12:52
 */
public class ClassTest {

    public static Set<Class> getAllClasses(String packageName, Class interfaceClass) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        Set<Class> classes = Sets.newHashSet();

        String packagePath = StringUtils.replace(packageName, ".", "/");

        URL packageUrl = classLoader.getResource(packagePath);

        if (packageUrl == null) {
            return classes;
        }

        File packageDir = new File(packageUrl.getPath());
        File[] classFile = packageDir.listFiles();

        if (classFile == null || classFile.length == 0) {
            return classes;
        }

        for (File file : classFile) {
            if (file.isDirectory()) {
                classes.addAll(getAllClasses(packageName + "." + file.getName(), interfaceClass));
            } else {
                if (StringUtils.endsWithIgnoreCase(file.getName(), ".class")) {
                    try {
                        String clazzName = packageName + "." + StringUtils.substringBefore(file.getName(), ".");
                        Class clazz = ClassUtils.getClass(classLoader, clazzName);

                        if (ClassUtils.isAssignable(clazz, interfaceClass)) {
                            classes.add(clazz);
                        }

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return classes;
    }

    public static void main(String[] args) throws Exception {

        Set<Class> classes = getAllClasses("io.github.ketao1989.disruptor", EventHandler.class);

        for (Class clazz : classes) {
            System.out.println(clazz.getName());
        }

    }
}
