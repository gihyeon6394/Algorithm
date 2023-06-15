package basic;

import lib.StdOut;
import lib.StdRandom;

public class ThreeSumClient {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];

        // 10, 100, 1000, 10000, 100000, 1000000, ...

        // 랜덤 수 할당
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000000, 1000000);
        }

        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapsedTime();
        StdOut.println(cnt + " triples" + time + " seconds");

    }
}
