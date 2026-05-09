/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication4;

/**
 *
 * @author prathameshgarsule
 */
public class JavaApplication4 {

    public static void main(String[] args) {

        // Clock times of processes
        int clocks[] = {100, 105, 98, 102};

        int n = clocks.length;
        int sum = 0;

        // Step 1: Calculate total time
        for (int i = 0; i < n; i++) {
            sum += clocks[i];
        }

        // Step 2: Find average time
        int avg = sum / n;

        System.out.println("Average Time = " + avg);

        // Step 3: Adjust each clock
        for (int i = 0; i < n; i++) {

            int diff = avg - clocks[i];

            clocks[i] += diff;

            System.out.println(
                "Process " + i +
                " adjusted by " + diff +
                " -> New Time = " + clocks[i]
            );
        }
    }
}

