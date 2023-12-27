package org.algorithm.sorting;

import static org.algorithm.sorting.Example.*;

public class Selection {

    // a[]를 오름차순으로 정렬
    public static void sort(Comparable[] a) {

        int N = a.length;

        for (int i = 0; i < N; i++) {
            // a[i]를 a[i+1..N] 중에서 가장 작은 원소와 교환
            int idxMin = i;

            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[idxMin])) idxMin = j;
            }
            exch(a, i, idxMin);
        }
    }

    public static void main(String[] args) {
        String[] a = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        assert isSorted(a);
        show(a);

        Integer[] b = new Integer[]{8, 2, 4, 9, 3, 6, 1, 5, 7, 0};
        sort(b);
        assert isSorted(b);
        show(b);
    }

}
