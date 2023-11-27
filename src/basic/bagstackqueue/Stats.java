package basic.bagstackqueue;


import lib.Bag;
import lib.StdIn;

/**
 * Bag client code
 */
public class Stats {

    public static void main(String[] args) {
        Bag<Double> nubmers = new Bag<Double>();


        // double 추가
        while (!StdIn.isEmpty()) {
            nubmers.add(StdIn.readDouble());
        }

        int N = nubmers.size();

        double sum = 0.0;

        for (double x : nubmers)
            sum += x;

        double mean = sum / N;

        sum = 0.0;

        for (double x : nubmers)
            sum += (x - mean) * (x - mean);

        double std = Math.sqrt(sum / (N - 1));

        System.out.printf("Mean: %.2f\n", mean);
        System.out.printf("Std dev: %.2f\n", std);

    }
}
