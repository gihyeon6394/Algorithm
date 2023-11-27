package sorting;

import static sorting.Example.*;

public class Selection {

    public static void sort(Comparable[] a) {
        // a[]를 오름차순으로 정렬

        int N = a.length;

        for (int i = 0; i < N; i++) {
            // a[i]를 a[i+1..N]에서 가장 작은 원소와 교환
            int min = i; // 가장 작은 원소의 인덱스
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.
        String[] a = new String[]{"c", "a", "b", "d", "e", "f", "g", "h", "i", "j", "k"};
        sort(a);
        assert isSorted(a);
        show(a);
    }


}
