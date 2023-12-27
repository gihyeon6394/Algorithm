package org.algorithm.sorting;

import static org.algorithm.sorting.Example.*;

public class Shell {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;

        // h-정렬의 간격 설정
        // ..., 121, 40, 13, 4, 1
        while (h < N / 3)
            h = 3 * h + 1;

        // h-정렬
        while (h >= 1) {
            System.out.println("h: " + h);
            for (int i = h; i < N; i++) {
                System.out.print(a[i]);

                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }

            }


            h = h / 3;
        }
    }

    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.
        String[] a = new String[]{"S", "H", "E", "L", "L", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        assert isSorted(a);
        System.out.println("Result");
        show(a);
    }
}
