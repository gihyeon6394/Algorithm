package org.algorithm.sorting;


import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class CompareSorting {

    private Double[] generateRandomArray(int i) {
        Double[] arr = new Double[i];
        for (int j = 0; j < i; j++) {
            arr[j] = Math.random();
        }
        return arr;
    }

    @Benchmark
    public void sorting_insertion() {
        Double[] arr = generateRandomArray(1000);
        Insertion.sort(arr);
    }

    @Benchmark
    public void sorting_insertion_ordered() {
        Double[] arr = new Double[]{0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9};
        Insertion.sort(arr);
    }


    @Benchmark
    public void sorting_selection() {
        Double[] arr = generateRandomArray(1000);
        Selection.sort(arr);
    }

    @Benchmark
    public void sorting_selection_ordered() {
        Double[] arr = new Double[]{0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9};
        Selection.sort(arr);
    }

    @Benchmark
    public void sorting_shell() {
        Double[] arr = generateRandomArray(1000);
        Shell.sort(arr);
    }
}
