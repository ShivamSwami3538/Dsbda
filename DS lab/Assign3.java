package javaapplication2;

import mpi.*;

public class Assign3 {

    public static void main(String[] args) throws Exception {

        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;

        // Elements per processor
        int part = n / size;

        int start = rank * part;
        int end = start + part;

        int local_sum = 0;

        // Calculate local sum
        for (int i = start; i < end; i++) {
            local_sum += arr[i];
        }

        // Display intermediate sum
        System.out.println("Processor " + rank + " sum = " + local_sum);

        int total[] = new int[1];

        // Combine all local sums
        MPI.COMM_WORLD.Reduce(
                new int[]{local_sum}, 0,
                total, 0,
                1, MPI.INT, MPI.SUM, 0
        );

        // Final result
        if (rank == 0) {
            System.out.println("Total Sum = " + total[0]);
        }

        MPI.Finalize();
    }
}