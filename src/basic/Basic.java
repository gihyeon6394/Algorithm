package basic;

import lib.StdOut;

import java.util.Arrays;
import java.util.Scanner;

public class Basic {

    public static void main(String[] args) {

        //System.out.println(1/0);
        // System.out.println(1.0 / 0.0);
        //practice();


        // testHistogram();
        //System.out.println(exR1(6));
        // System.out.println(exR1(6).equals("311361142246"));
        // exR2(2);
    }

    private static void testHistogram() {

        //1. 정수 i가 몇번 등장했는지 알려주는 지

        int[] arr1 = new int[]{1, 1, 3, 3, 3, 5};
        int[] resultVal1 = histogram(arr1, arr1.length);

        System.out.println(Arrays.toString(resultVal1));

        //2. 모든 항목이 0 과 M-1에 있을 때

        int[] arr2 = new int[]{2, 2, 3, 3, 3, 5, 3};
        int[] resultVal2 = histogram(arr2, arr2.length);

        System.out.println(Arrays.toString(resultVal2));
        System.out.println("합 : " + sumFromArr(resultVal2));

    }

    /**
     * 이진 탐색의 재귀적 구현
     */

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else return mid;
    }

    public static void practice() {

        System.out.println((0 + 15) / 2); //7
        System.out.println(2.0e-6 * 100000000.1); //200.0000002
        System.out.println(true && false || true && true); //true
        System.out.println((1 + 2.236) / 2); // int
        System.out.println(1 + 2 + 3 + 4.0); // double
        System.out.println(4.1 >= 4); // Boolean
        System.out.println(1 + 2 + "3"); // String

        // practice3();

        int a = 1;
        int b = 2;
        int c = 3;

        // if (a > b) then c = 0;// then 이라는 키워드가 없다.

        if (a > b) {
            c = 0;
        }
        if (a > b) c = 0;

        if (a > b) c = 0;
        else b = 0;

        // practice5();

        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
        // r    f   g
        //      0   1
        // 0    1   0
        // 1    1   1
        // 1    2   1
        // 2    3   2
        // 3    5   3
        // ...

        // practice7();

        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println('a' + 4);
        System.out.println((char) ('a' + 4));

        int N = 10;
        String s = Integer.toBinaryString(N);
        System.out.println(s);

        // practice11();
        // practice12();
        // practice13();
        practice14(2);
        practice14(16);
        practice14(17);
        // TODO. 15


    }

    /**
     * log2N이하의 가장 큰 정수를 리턴하라
     */
    private static void practice14(int N) {

        // x = log2N = x
        // 2의 x제곱 =  N

        int a = 1;

        int result = 0;

        if (N >= 2) {
            int flag = 1;

            for (int i = 1; i <= flag; flag++) {
                a *= 2;
                // a가 N보다 커지면 멈춤
                if (a >= N)
                    break;
            }
            result = a > N ? --flag : flag;
        }

        System.out.println(N + " then result = " + result);

        // return x 이하의 가장 큰 정수


    }

    /**
     * TODO. 95p 13
     * 2차원 배열의 행과 열을 바꾸는 90도 회전 코드를 작성하라
     * N*M -> M*N
     */
    private static void practice13() {
        int[][] a1 = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                a1[i][j] = (int) (Math.random() * 100);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(a1[i][j] + "   ");
            }
            System.out.println();
        }

        int[][] a2 = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                a2[i][j] = a2[j][i];
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(a2[i][j] + "   ");
            }
            System.out.println();
        }


    }

    private static void practice12() {
        System.out.println("practice12");
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        System.out.println(Arrays.toString(a));
        // 9, 8, 7, ... , 1, 0
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }

        System.out.println(Arrays.toString(a));

    }

    private static void practice11() {
        boolean[][] a1 = new boolean[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i + " " + j + " : " + a1[i][j] + " : " + (a1[i][j] ? "true" : "  "));
            }
        }


    }


    private static void practice7() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
            StdOut.printf("%.5f\n", t);
        }
        //아무것도 안찍힘

        int sum = 0;
        for (int i = 1; i < 1000; i++) {

            //
            for (int j = 0; j < i; j++) {
                sum++;
            }
            StdOut.println(sum);
        }

        int result1 = 0;
        for (int i = 0; i <= 999; i++) {
            result1 += i;
        }
        System.out.println(result1);

        int sum2 = 0;

        for (int i = 1; i < 1000; i *= 2) {

            for (int j = 0; j < 1000; j++) {
                sum2++;
            }
            StdOut.println(sum2);
        }


    }

    /**
     * Double x, y 가 0과 1사이에 있는지 확인
     */
    private static void practice5() {
        Double x = 0.1;
        Double y = 0.9;

        String result = "false";

        if (x > 0 && x < 1 && y > 0 && y < 1) {
            result = "true";
        }
        System.out.println(result);

    }

    private static void practice3() {
        Scanner sc = new Scanner(System.in);

        System.out.print("input number 3 :");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        String result = "not equal";

        if (a == b && a == c && b == c) {
            result = "equal";
        }
        System.out.println(result);

    }


    /**
     * 1.1.15
     *
     * @param int[] a, int M
     * @return 크기가 M인 int배열,  i번째 항목은 a[]에서 정수 i의 등장 횟수
     * 만약 a[] 각 항목들이 0과 M-1 사이라면 리턴되는 배열의 총합이 a.length와 같아야함
     */

    public static int[] histogram(int[] a, int M) {

        // M = size of a

        int[] resultArr = new int[M];

        int existOuter = 0; // 0 모든 항목이  0과 M-1 사이임
        for (int i = 0; i < M; i++) {
            resultArr[i] = getCountFromArr(a, i);

            if (!(a[i] >= 0 && a[i] <= M - 1)) {
                existOuter = 1;
            }
        }

        if (existOuter == 1) {
            int sum = sumFromArr(resultArr);

            if (sum != a.length) {
                resultArr = validateArr(resultArr, M);
            }
        }
        return resultArr;
    }

    /**
     * m = 같아야하는 값
     *
     * @return
     */
    private static int[] validateArr(int[] a, int m) {
        int sum = sumFromArr(a); // 10
        int lastVal = a[a.length - 1];  // 7
        a[a.length - 1] = a[a.length - 1] + (sum - lastVal);

        return a;

    }

    private static int sumFromArr(int[] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    private static int getCountFromArr(int[] a, int val) {
        int resultVal = 0;

        // val이 등장한 회수 카운트
        for (int i = 0; i < a.length; i++) {
            if (a[i] == val)
                resultVal++;
        }
        return resultVal;

    }


    /**
     * 1.1.16 exR1(6)의 리턴값
     */
    private static String exR1(int n) {
        // n이 0보다 같거나 작으면 return
        if (n <= 0) return "";

        // return
        //  exR1(3)     6       exR1(4)      6
        // ""+3+exR1(1)+3
        //  1+""+1
        // 3113
        //                      exr1(1)+4+exr1(2)+4
        //                      11+4+exr1(2)+4
        //                      2+""+2
        //                      114224
        // 311361142246
        //
        //
        //
        //
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }


    /**
     * 1.1.17
     * Exception in thread "main" java.lang.StackOverflowError
     * */
    private static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        if (n <= 0) return "";
        return s;
    }
}

