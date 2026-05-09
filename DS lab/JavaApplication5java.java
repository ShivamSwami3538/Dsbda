/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

public class JavaApplication2 {

    public static void main(String[] args) throws InterruptedException {

        int n = 5;
        int token = 0;

        for (int i = 0; i < 10; i++) {

            System.out.println("Token at Process " + token);

            System.out.println("Process " + token + " ENTERING CS");

            Thread.sleep(1000);

            System.out.println("Process " + token + " EXITING CS\n");

            // Pass token to next process
            token = (token + 1) % n;
        }
    }
}