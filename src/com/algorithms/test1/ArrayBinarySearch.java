package com.algorithms.test1;

class BinaryArray {
    private int nElems;
    private long[] a;

    public BinaryArray(int nElems, long[] a) {
        this.nElems = nElems;
        this.a = a;
    }

    public int getnElems() {
        return nElems;
    }

    public void setnElems(int nElems) {
        this.nElems = nElems;
    }

    public long[] getA() {
        return a;
    }

    public void setA(long[] a) {
        this.a = a;
    }

    public String find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        int i = 0;
        while (true) {
            i++;
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return "Количество итераций: " + i; // Элемент найден
            else if (lowerBound > upperBound)
                return "Элемента " + searchKey + " не найдено!"; // Элемент не найден
            else // Деление диапазона
            {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1; // В верхней половине
                else
                    upperBound = curIn - 1; // В нижней половине
            }
        }
    }
}

public class ArrayBinarySearch {


    public static void main(String[] args) {
        long[] longs = new long[100];
        for (int i = 0; i < longs.length; i++) {
            longs[i] = i;
        }

        BinaryArray binaryArray = new BinaryArray(100, longs);

        System.out.println(binaryArray.find(167));
    }
}

