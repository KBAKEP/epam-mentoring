package com.epam.montoring.module5.task3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class CustomClassloader extends ClassLoader {

    private Map<String, Class<?>>    classes = new HashMap<String, Class<?>>();

    private String classpath;

    public CustomClassloader(String classpath) {

        this(CustomClassloader.class.getClassLoader(), classpath);
    }

    public CustomClassloader(ClassLoader parent, String classpath) {

        super(parent);
        this.classpath = classpath;
    }

    public Class<?> loadClass(String className) throws ClassNotFoundException {

        return findClass(className);
    }

    public Class<?> findClass(String className) {

        Class<?> result = null;

        result = (Class<?>) classes.get(className); // checks in cached classes
        if (result != null) {
            return result;
        }

        try {
            return findSystemClass(className);
        } catch (Exception e) {
        }

        try {
            File root = new File(classpath);
            File[] list = root.listFiles();

            if (list == null)
                throw new FileNotFoundException();
            
            byte[] bytesFile = null;

            for (File file : list) {
                
                String classShortName = className.substring(className.lastIndexOf('.') + 1);;
                
                if (file.getName().equals(classShortName)) {

                    bytesFile = new byte[(int) file.length()];

                    try {
                        FileInputStream fileInputStream = null;
                        // convert file into array of bytes
                        fileInputStream = new FileInputStream(file);
                        fileInputStream.read(bytesFile);
                        fileInputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    
                    break;
                }
            }

            if (bytesFile == null) throw new IllegalStateException();
            
            result = defineClass(className, bytesFile, 0, bytesFile.length, null);
            classes.put(className, result);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

}
