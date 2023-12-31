package org.algorithm.sorting;

import org.algorithm.lib.StdRandom;

import static org.algorithm.sorting.Example.*;

public class Quick {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 입력 배열을 섞는다.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return; // 배열의 크기가 1 이하면 종료

        int j = partition(a, lo, hi); // 분할

        sort(a, lo, j - 1); // 왼쪽 부분 배열을 정렬
        sort(a, j + 1, hi); // 오른쪽 부분 배열을 정렬
    }

    // a[]를 a[lo..j-1], a[j], a[j+1..hi]로 분할하고 j를 반환
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1; // 왼쪽과 오른쪽 스캔 인덱스
        Comparable v = a[lo]; // 분할 기준 원소

        // 좌/우 끝에서 시작해서 서로 교차할 때까지 반복
        while (true) {
            while (less(a[++i], v)) if (i == hi) break; // 왼쪽부터 v보다 같거나 큰 원소 찾기
            while (less(v, a[--j])) if (j == lo) break; // 오른쪽부터 v보다 같거나 작은 원소 찾기
            if (i >= j) break; // 인덱스가 교차하면 종료
            exch(a, i, j);
        }

        exch(a, lo, j); // v를 a[j]와 교환
        return j; // a[lo..j-1] <= a[j] <= a[j+1..hi]를 만족하도록 분할
    }

    public static void main(String[] args) {
        String[] a = new String[]{"Q", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        assert isSorted(a);
        show(a);

    }
}
