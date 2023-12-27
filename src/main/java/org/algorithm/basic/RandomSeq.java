package org.algorithm.basic;

import org.algorithm.lib.StdOut;
import org.algorithm.lib.StdRandom;

public class RandomSeq {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);

        // 10, 100, 1000, 10000, 100000, 1000000, ...

        // 랜덤 수 할당
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform(lo, hi);
            StdOut.printf("%.2f\n", x);
        }
    }
}
