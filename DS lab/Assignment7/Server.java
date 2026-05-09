/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication7;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class JavaApplication7 {

    public static void main(String[] args) throws Exception {

        // Use a free port
        HttpServer server = HttpServer.create(
                new InetSocketAddress(9090), 0
        );

        server.createContext("/add", new AddHandler());

        server.setExecutor(null);

        server.start();

        System.out.println(
                "Server started at http://localhost:9090"
        );
    }
}

class AddHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange)
            throws IOException {

        String query =
                exchange.getRequestURI().getQuery();

        int a = 0;
        int b = 0;

        if (query != null) {

            String params[] = query.split("&");

            for (String p : params) {

                String pair[] = p.split("=");

                if (pair[0].equals("a")) {
                    a = Integer.parseInt(pair[1]);
                }

                if (pair[0].equals("b")) {
                    b = Integer.parseInt(pair[1]);
                }
            }
        }

        int result = a + b;

        String response = "Result = " + result;

        exchange.sendResponseHeaders(
                200,
                response.length()
        );

        OutputStream os =
                exchange.getResponseBody();

        os.write(response.getBytes());

        os.close();
    }
}