package com.epam.montoring.module6.task5;


public class Container {
    
    private static int counter = 0;
    private String string;
    private static final String string1 = "111111111111111111111111111111";
    private static final String string2 = "111111112111111111111111111111";
    private static final String string3 = "111111111311111111111111111111";
    private static final String string4 = "111111111141111111111111111111";
    
    private Container container;
    
    public Container() {
        string = new String("11111111111111111" + ++counter);
        container = new Container();
        
    }
    
}
