package basic;

import lib.StdRandom;

/**
 * 250부터 2배씩 곱해서 실행시간 계산
 */
public class DoublingTest {

    public static void main(String[] args) {
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            System.out.printf("%7d %5.1f\n", N, time);
        }
    }

    // 6자리 무작위 int 값 N개에 대한 count 실행 시간
    private static double timeTrial(int N) {

        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            // -MAX ~ MAX 사이의 무작위 정수
            a[i] = StdRandom.uniform(-MAX, MAX);
        }

        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }
}
