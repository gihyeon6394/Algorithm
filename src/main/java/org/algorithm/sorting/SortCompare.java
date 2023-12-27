package org.algorithm.sorting;

public class SortCompare {

    public static double time(String alg, Comparable[] a) {
        double start = System.currentTimeMillis();

        if ("Insertion".equals(alg)) {
            Insertion.sort(a);
        }
        if ("Selection".equals(alg)) {
            Selection.sort(a);
        }

        double end = System.currentTimeMillis();

        return end - start;
    }

    public static double timeRandomInput(String alg, int lengthArr, int cntArr) {

        double total = 0.0;
        Double[] a = new Double[lengthArr];

        for (int t = 0; t < cntArr; t++) {
            for (int i = 0; i < lengthArr; i++) {
                a[i] = Math.random();
            }
            total += time(alg, a);
        }

        return total;
    }

    public static void main(String[] args) {
        String algInsertion = "Insertion";
        String algSelection = "Selection";

        int lengthArr = 1000; // 배열의 길이
        int cntArr = 10000; // 배열의 개수

        double t1 = timeRandomInput(algInsertion, lengthArr, cntArr);
        double t2 = timeRandomInput(algSelection, lengthArr, cntArr);

        System.out.println("Insertion: " + t1);
        System.out.println("Selection: " + t2);

    }
}
