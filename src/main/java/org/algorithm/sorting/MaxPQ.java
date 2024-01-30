package org.algorithm.sorting;


public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq; // 힙 정렬된 완전 이진 트리
    private int N = 0; // pq[1..N]만 사용, pq[0]은 비워둠

    public MaxPQ(int maxN) {
        this.pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * N을 증분하여, 마지막 인덱스에 새로운 키 삽입
     *
     * @param v
     */
    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    /**
     * 루트노드를 꺼내고, 마지막 항목을 루트노드로 옮긴 후 하향식 복구
     *
     * @return
     */
    public Key delMax() {
        Key max = pq[1]; // 루트 노드
        exch(1, N--); // 마지막 항목과 교환
        pq[N + 1] = null; // 로이터링 방지 (로이터링 : 안쓰는 메모리 점유)
        sink(1);
        return max;
    }

    private void swim(int k) {

        // (루트노드가 아님 and 부모보다 큰 경우) 반복
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k); // 부모와 교환
            k = k / 2;
        }
    }

    private void sink(int k) {

        // 자식노드보다 같거나 작으면 반복
        while (2 * k <= N) {
            int j = 2 * k; // 자식 노드
            if (j < N && less(j, j + 1)) j++; //자식노드랑 비교 후, 형제노드와 비교
            if (!less(k, j)) break; //자식노드보다 크면 break

            exch(k, j); // 자식이랑 교환
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    // 원소 i와 j 교환
    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
