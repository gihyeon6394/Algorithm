package org.algorithm.sorting;

import static org.algorithm.sorting.Example.less;

public class Merge {

    private static Comparable[] aux; // 병합을 위한 작업용 임시 배열

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length]; // 임시 배열 생성
        sort(a, 0, a.length - 1); // 재귀 호출
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return; // 종료 조건

        int mid = lo + (hi - lo) / 2; // 중간 지점 계산

        sort(a, lo, mid); // 왼쪽 절반 정렬
        sort(a, mid + 1, hi); // 오른쪽 절반 정렬

        merge(a, lo, mid, hi); // 병합
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            // a[lo..hi]를 aux[lo..hi]에 복사
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            // 병합된 결과를 a[lo..hi]에 저장
            if (i > mid) a[k] = aux[j++]; // 왼쪽 절반 소진
            else if (j > hi) a[k] = aux[i++]; // 오른쪽 절반 소진
            else if (less(aux[j], aux[i])) a[k] = aux[j++]; // 오른쪽이 더 작으면 오른쪽 원소 삽입
            else a[k] = aux[i++]; // 왼쪽이 더 작으면 왼쪽 원소 삽입
        }
    }

    public static void main(String[] args) {
        String[] a = new String[]{"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        assert Example.isSorted(a);
        Example.show(a);
    }

}
