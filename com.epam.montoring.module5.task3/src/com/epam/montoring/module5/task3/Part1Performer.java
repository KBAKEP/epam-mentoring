package com.epam.montoring.module5.task3;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

public class Part1Performer {

    public static void perform() throws MalformedURLException, ClassNotFoundException,
            NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, InstantiationException {

//        performByPathToFile();

        performByPathToDirectory();

    }

    // path to class file:
    // file:  D:\\temp\\
    public static void performByPathToDirectory() throws MalformedURLException,
            ClassNotFoundException, NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            InstantiationException {

        String classPath;

        System.out.println("Enter path here : ");

        Scanner scanIn = new Scanner(System.in);
        classPath = scanIn.nextLine();
        scanIn.close();

        if (classPath == null || classPath.equals("")) {
            System.exit(1);
        }

        File file = new File(classPath);

        // convert the file to URL format
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{ url };

        // load this folder into Class loader
        ClassLoader clsLoader = new URLClassLoader(urls);
        Class clazz = clsLoader.loadClass("com.epam.montoring.module5.task3.Semaphore");
        Method method = clazz.getMethod("lever", null);
        method.invoke(clazz.newInstance());
    }

    // path to class file:
    // file:D:/temp/Semaphore.class
    public static void performByPathToFile() throws MalformedURLException, ClassNotFoundException,
            NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, InstantiationException {

        String classPath;

        System.out.println("Enter path here : ");

        Scanner scanIn = new Scanner(System.in);
        classPath = scanIn.nextLine();
        scanIn.close();

        if (classPath == null || classPath.equals("")) {
            System.exit(1);
        }
        // classPath.replaceAll("\\", System.lineSeparator());
        // classPath.replaceAll("/", System.lineSeparator());

        URLClassLoader clsLoader = URLClassLoader.newInstance(new URL[]{ new URL(classPath) });
        Class clazz = clsLoader.loadClass("com.epam.montoring.module5.task3.Semaphore");
        Method method = clazz.getMethod("work", null);
        method.invoke(clazz.newInstance());
    }
}
