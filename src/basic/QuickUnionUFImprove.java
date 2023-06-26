package basic;

/**
 * 1.
 * root 노드까지의 거리를 균일하게 분포시킨다
 * 즉, 트리의 레벨이 너무 커지지 않게
 * <p>
 * 2. 트리 레벨 평탄화
 * <p>
 * 루트를 찾으러 올라갈 때 할아버지-자식의 거리를 1 줄임
 */
public class QuickUnionUFImprove {
    private int[] id;
    private int[] sz; // i가 속한 트리의 자식 수

    public QuickUnionUFImprove(int[] id) {
        this.id = id;
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * root의 index 반환
     */
    private int root(int idx) {
        while (id[idx] != idx) {
            id[idx] = id[id[idx]];
            idx = id[idx];
        }
        return idx;
    }

    /**
     * id[p]와 id[q]가 연결되어있는가?
     */
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * id[p]와 id[q]를 연결
     */
    public void union(int p, int q) {


        if (connected(p, q)) {
            return;
        }
        int i = root(p);
        int j = root(q);

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }


    }

}
