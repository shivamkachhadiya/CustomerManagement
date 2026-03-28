package com.mycompany.customermanagement;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class CustomerManagement {
    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", exchange -> {

            // Create customer
            Customer customer = new Customer("John Doe", "123 Main Street");

            // Create items
            Item item1 = new Item("Laptop", 2.5);
            Item item2 = new Item("Mouse", 0.5);

            // Create order details
            OrderDetail detail1 = new OrderDetail(2, "taxable", item1);
            OrderDetail detail2 = new OrderDetail(3, "non-taxable", item2);

            // Create order
            Order order = new Order(customer);
            order.addOrderDetail(detail1);
            order.addOrderDetail(detail2);

            // Build response
            String response =
                    "Customer: " + customer + "\n" +
                    "Order Date: " + order.getDate() + "\n" +
                    "Order Status: " + order.getStatus() + "\n" +
                    "Sub Total: " + order.calcSubTotal() + "\n" +
                    "Tax: " + order.calcTax() + "\n" +
                    "Total: " + order.calcTotal() + "\n" +
                    "Total Weight: " + order.calcTotalWeight() + "\n";

            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();
        System.out.println("Server started on port 8080");
    }
}