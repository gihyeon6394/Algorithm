package basic;

public class QuickUnionUF {

    private int[] id;

    public QuickUnionUF(int[] id) {
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
        id[i] = j;

    }


}
