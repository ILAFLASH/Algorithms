package com.algorithms.test2;

class ArrayBub {
    private long[] a; // Ссылка на массив a
    private int nElems; // Количество элементов данных

    public ArrayBub(int max) // Конструктор
    {
        a = new long[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
    }

    public long[] getA() {
        return a;
    }

    public void setA(long[] a) {
        this.a = a;
    }

    public int getnElems() {
        return nElems;
    }

    public void setnElems(int nElems) {
        this.nElems = nElems;
    }

    public void insert(long value) // Вставка элемента в массив
    {
        a[nElems] = value; // Собственно вставка
        nElems++; // Увеличение размера
    }

    public void display() // Вывод содержимого массива
    {
        for (int j = 0; j < nElems; j++) // Для каждого элемента
            System.out.print(a[j] + " "); // Вывод
        System.out.println("");
    }

    public void bubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 1; out--) // Внешний цикл (обратный)
            for (in = 0; in < out; in++) // Внутренний цикл (прямой)
                if (a[in] > a[in + 1]) // Порядок нарушен?
                    swap(in, in + 1); // Поменять местами
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
} // Конец класса ArrayBub

class BubbleSort {
    public static void main(String[] args) {
        int maxSize = 100_000; // Размер массива
        ArrayBub arr; // Ссылка на массив
        arr = new ArrayBub(maxSize); // Создание массива
        for (int i = 0; i < maxSize ; i++) {
            arr.insert((long) (Math.random() * (maxSize - 1)));
        }
        arr.display(); // Вывод элементов
        long start = System.currentTimeMillis();
        arr.bubbleSort(); // Пузырьковая сортировка элементов
        long end = System.currentTimeMillis();
        System.out.println("Время сортировки 100_000 элементов методом пузырька: " + (end - start));
        arr.display(); // Повторный вывод
    } //
} // Конец класса BubbleSort
