package com.epam.montoring.module6.task3;

import java.util.HashMap;
import java.util.Map;

import javassist.ClassPool;

public class OutOfMemoryRunner {

    public static void main(String[] args) {

       
        
        outOfHeapSpace();
        
//        try {
//            outOfPermGen();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e.getStackTrace());
//            System.out.println(e.getMessage());
//        }

    }

    private static void outOfHeapSpace() {

        Map<Key, String> map = new HashMap<Key, String>();
        
        while(true) {
            map.put(new Key(), "1111111111111111111111111111112222222222");
        }
//        System.out.println("END");
    }

    private static void outOfPermGen() throws Exception {

        for (int i = 0; i < 100_000_000; i++) {
            generate("com.epam.mentoring.Generated" + i);
        }
    }

    public static Class generate(String name) throws Exception {

        ClassPool pool = ClassPool.getDefault();
        return pool.makeClass(name).toClass();
    }

    static class NewClassloader extends ClassLoader {

        private ClassLoader previous;

        public NewClassloader(ClassLoader previous) {

            super(NewClassloader.class.getClassLoader());
            this.previous = previous;
        }

        public NewClassloader() {

            super(NewClassloader.class.getClassLoader());
        }

    }
}
