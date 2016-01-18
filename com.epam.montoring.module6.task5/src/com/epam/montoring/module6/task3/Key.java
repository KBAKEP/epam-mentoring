package com.epam.montoring.module6.task3;

public class Key {

    static int counter = 0;
    int        i       = counter++;

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + i;
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Key other = (Key) obj;
        if (i != other.i)
            return false;
        return true;
    }

}
