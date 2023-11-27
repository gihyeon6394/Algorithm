package sorting;

import static sorting.Example.*;

public class Insertion {

    public static void sort(Comparable[] a) {
        // a[]를 오름차순으로 정렬

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
        String[] a = new String[]{"c", "a", "b", "d", "e", "f", "g", "h", "i", "j", "k"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
