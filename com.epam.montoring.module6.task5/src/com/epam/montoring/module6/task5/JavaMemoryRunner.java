package com.epam.montoring.module6.task5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class JavaMemoryRunner {

    public static void main(String[] args) throws FileNotFoundException {

        reproduceStackOverflow();
        
       
    }
    
    private static void reproduceStackOverflow() {
        Container container = new Container();
    }
    
    private void justTry() throws FileNotFoundException {
        String result = "";
        String line = null;

        StringBuffer buffer = new StringBuffer();

        while (true) {

            File file = new File("external/2.doc");

            BufferedReader br = new BufferedReader(new FileReader(file));

            try {
                while ((line = br.readLine()) != null) {
                    buffer.append(line);
                    result = result + " " + line;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}
