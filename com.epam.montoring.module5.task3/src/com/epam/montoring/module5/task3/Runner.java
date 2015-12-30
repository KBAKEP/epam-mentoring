package com.epam.montoring.module5.task3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

//        String classPath = "./external/";
        String classPath = null;

        System.out.println("Enter path here : ");

        Scanner scanIn = new Scanner(System.in);
        classPath = scanIn.nextLine();
        scanIn.close();

        if (classPath == null || classPath.equals("")) {
            printFailAndExit();
        }

        CustomClassloader classloader = new CustomClassloader(classPath);
        try {
            Class clazz = classloader.loadClass("com.epam.montoring.module5.task3.Semaphore");
            Method method = clazz.getMethod("lever", null);
            method.invoke(clazz.newInstance());
            
            System.out.println("SUCCESS");

        } catch (Exception e) {
            printFailAndExit(e);
        }

    }

    private static void printFailAndExit() {

        printFailAndExit(null);

    }

    private static void printFailAndExit(Exception e) {

        System.out.println("ERROR");
        e.printStackTrace();
        System.exit(1);
    }

}
