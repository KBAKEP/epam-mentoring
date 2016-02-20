package com.epam.montoring.module7.task9;

import java.util.ArrayList;
import java.util.Random;


public class GCRunner {

    static class Thr extends Thread {

        @Override
        public void run() {

            for (int i = 0; i < 999999; i++) {
                
                System.out.println("i = " + i);
                
                if (i == 12346) {
                    this.interrupt();
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println("main");
        
        Thr thr  = new Thr();
        thr.start();
        System.out.println("main 2");
        
        
        try {
            thr.join();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e);
        }
      
    }

}
