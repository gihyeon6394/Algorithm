package org.algorithm.sorting;


import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class CompareSortingQuickMerge {

    private Double[] generateRandomArray(int i) {
        Double[] arr = new Double[i];
        for (int j = 0; j < i; j++) {
            arr[j] = Math.random();
        }
        return arr;
    }

    @Benchmark
    public void sorting_merge() {
        Double[] arr = generateRandomArray(1000);
        Merge.sort(arr);
    }

    @Benchmark
    public void sorting_quick() {
        Double[] arr = generateRandomArray(1000);
        Quick.sort(arr);
    }

}
