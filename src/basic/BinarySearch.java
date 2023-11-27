package basic;

import lib.In;
import lib.StdIn;
import lib.StdOut;

import java.util.Arrays;

public class BinarySearch {


    public static void main(String[] args) {

        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist); // 오름차순 정렬
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1) {
                StdOut.println(key);
            }
        }
    }


    // white list에 있는지 여부 탐색
    public static int rank(int key, int[] a) {
        // a 는 이미 정렬된 상태이다.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
