/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication6;

/**
 *
 * @author prathameshgarsule
 */
public class JavaApplication6 {
    static int processes[] = {1, 2, 3, 4, 5};
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   

    // List of processes
   
   

        int initiator = 2; // Process starting election

        bully(initiator);
    }

    // Bully Algorithm Function
    static void bully(int initiator) {

        System.out.println("Process " + initiator + " starts election");

        boolean higherFound = false;

        // Send election message to higher-numbered processes
        for (int i = 0; i < processes.length; i++) {

            if (processes[i] > initiator) {

                System.out.println(
                    "Message sent from Process "
                    + initiator
                    + " to Process "
                    + processes[i]
                );

                higherFound = true;
            }
        }

        // If no higher process exists, become leader
        if (!higherFound) {

            System.out.println(
                "Process " + initiator + " becomes LEADER"
            );

        } else {

            // Highest process becomes leader
            int highest = processes[processes.length - 1];

            bully(highest);
        }
    }
}
    