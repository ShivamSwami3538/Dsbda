/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication7;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Client {

    public static void main(String[] args) {

        try {

            // Connect to server
            URL url = new URL(
                    "http://localhost:9090/add?a=5&b=3"
            );

            // Read response from server
            BufferedReader br =
                    new BufferedReader(
                            new InputStreamReader(
                                    url.openStream()
                            )
                    );

            String response;

            // Display server response
            while ((response = br.readLine()) != null) {

                System.out.println(
                        "Response from Server: "
                        + response
                );
            }

            // Close stream
            br.close();

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}
