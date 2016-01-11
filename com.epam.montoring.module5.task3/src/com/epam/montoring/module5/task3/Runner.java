package com.epam.montoring.module5.task3;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Runner {

    public static final String    SEMAPHORE_CLASSNAME = "com.epam.montoring.module5.task3.Semaphore";
    
    public static void main(String[] args) {

        reloadClass();
    }

    private static void printFailAndExit() {

        printFailAndExit(null);

    }

    private static void loadClass() {

        // String classPath = "./external/";
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
            Class clazz = classloader.loadClass(SEMAPHORE_CLASSNAME);
            Method method = clazz.getMethod("lever", null);
            method.invoke(clazz.newInstance());

            System.out.println("SUCCESS");

        } catch (Exception e) {
            printFailAndExit(e);
        }

    }

    private static void reloadClass() {

        Scanner scanIn = new Scanner(System.in);
        
        do {
            String classPath = null;

            System.out.println("Enter path here : ");
           
            classPath = scanIn.nextLine();

            if (classPath == null || classPath.equals("")) {
                continue;
            }

            CustomClassloader classloader = new CustomClassloader(classPath);
            
            try {
                Class clazz = classloader.loadClass(SEMAPHORE_CLASSNAME);
                Method method = clazz.getMethod("lever", null);
                method.invoke(clazz.newInstance());

                System.out.println("SUCCESS");

            } catch (Exception e) {
                scanIn.close();
                printFailAndExit(e);
            }
        } while (true);
        
    }

    private static void printFailAndExit(Exception e) {

        System.out.println("ERROR");
        e.printStackTrace();
        System.exit(1);
    }
}
