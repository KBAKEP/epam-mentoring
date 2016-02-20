package com.epam.montoring.module6.task5;


public class Container {
    
    private static int counter = 0;
    private String string;
    
    private Container container;
    
    public Container() {
        string = new String("11111111111111111" + ++counter);
        container = new Container();
        
    }
    
}
