package com.epam.montoring.module7.task9;

import java.util.ArrayList;
import java.util.Random;


public class GCRunner {

    public static void main(String[] args) {

        while (true) {
            Random random = new Random(System.currentTimeMillis());
            ArrayList<Integer> list = new ArrayList<Integer>(random.nextInt(1000*1000) + 1);
        }

    }

}
