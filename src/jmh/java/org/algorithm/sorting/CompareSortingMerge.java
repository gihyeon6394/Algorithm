package org.algorithm.sorting;


import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class CompareSortingMerge {

    private Double[] generateRandomArray(int i) {
        Double[] arr = new Double[i];
        for (int j = 0; j < i; j++) {
            arr[j] = Math.random();
        }
        return arr;
    }

    @Benchmark
    public void sorting_insertion() {
        Double[] arr = generateRandomArray(15);
        Insertion.sort(arr);
    }

    @Benchmark
    public void sorting_merge() {
        Double[] arr = generateRandomArray(15);
        Merge.sort(arr);
    }

    @Benchmark
    public void sorting_insertion_big() {
        Double[] arr = generateRandomArray(1000);
        Insertion.sort(arr);
    }

    @Benchmark
    public void sorting_merge_big() {
        Double[] arr = generateRandomArray(1000);
        Merge.sort(arr);
    }

}
