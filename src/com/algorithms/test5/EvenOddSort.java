package com.algorithms.test5;

class ArrayEvenOdd {
    private long[] a; // Ссылка на массив a
    private int nElems; // Количество элементов данных

    public ArrayEvenOdd(int max) // Конструктор
    {
        a = new long[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
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

    public void evenOddSort() {
        boolean isSwap;
        int in, out;
        do { // цикл с проверкой на хотя бы одну перестановку
            isSwap = false; // устанавливаем маркер перестановки в false
            for (out = 0; out < 2; out++) { // проверяем массив дважды, начиная с 0 и 1 элемента
                for (in = out; in < nElems; in += 2) {
                    if (in < nElems - 1) { // не выходим за границы массива
                        if (a[in] > a[in + 1]) { // меняем элементы местами, если левый больше правого
                            long temp = a[in];
                            a[in] = a[in + 1];
                            a[in + 1] = temp;
                            isSwap = true; // была перестановка
                        }
                    }
                }
            }
        } while (isSwap); // если перестановки не было, сортировка закончена
    }
} // Конец класса ArrayEvenOdd

public class EvenOddSort {
    public static void main(String[] args) {
        int maxSize = 100_000; // Размер массива
        ArrayEvenOdd arr; // Ссылка на массив
        arr = new ArrayEvenOdd(maxSize); // Создание массива
        for (int i = 0; i < maxSize; i++) {
            arr.insert((long) (Math.random() * (maxSize - 1)));
        }
        arr.display(); // Вывод элементов
        long start = System.currentTimeMillis();
        arr.evenOddSort(); // Сортировка методом вставки
        long end = System.currentTimeMillis();
        System.out.println("Время сортировки 100_000 элементов методом вставки: " + (end - start));
        arr.display(); // Повторный вывод
    }
}
