package org.algorithm.sorting;

import static org.algorithm.sorting.Example.*;

public class Insertion {

    // a[]를 오름차순으로 정렬
    public static void sort(Comparable[] a) {

        int N = a.length;

        for (int i = 1; i < N; i++) {
            // a[i]를 [i-1], [i-2], ... 에서 적절한 위치에 삽입
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.
        String[] a = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
