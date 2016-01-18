package com.epam.montoring.module6.task3;


public class HeapLeak {
    HeapLeak parent;

    String str = "12345111111111111111111167890" + "999999991111111111111999999";
    
    public HeapLeak() {
        
    }
    
    public HeapLeak(HeapLeak parent) {

        super();
        this.parent = parent;
    }
    
    
}
