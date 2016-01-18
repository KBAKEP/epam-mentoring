package com.epam.montoring.module5.task3;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MyUrlClassLoader extends URLClassLoader {

    public MyUrlClassLoader(URL[] urls) throws MalformedURLException {

        super(concatenateArrays(urls, new URL[] {new File("url_classloader_classpath/").toURI().toURL()}) );
        
    }
    
    private static URL[] concatenateArrays(URL[] urls1, URL[] urls2) {
        Collection<URL> collection = new ArrayList<URL>();
        collection.addAll(Arrays.asList(urls1));
        collection.addAll(Arrays.asList(urls2));

        URL[] urlAll = collection.toArray(new URL[] {});
        
        return urlAll;
    }
}
