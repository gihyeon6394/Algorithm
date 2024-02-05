package org.algorithm.sorting;

import static org.algorithm.sorting.Example.*;

public class HeapSort {

    public static void sort(Comparable[] a) {
        int N = a.length - 1;

        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }

        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }

    }


    private static void sink(Comparable[] a, int k, int N) {

        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j, j + 1)) j++;
            if (!less(a, k, j)) break;

            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int v, int w) {
        return a[v].compareTo(a[w]) < 0;
    }


    public static void main(String[] args) {

        String[] a = new String[]{null, "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        assert isSorted(a);
        show(a);
    }


}
