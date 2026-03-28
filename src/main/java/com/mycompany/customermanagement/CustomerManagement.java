package com.mycompany.customermanagement;

import java.util.Date;

public class CustomerManagement {
    public static void main(String[] args) {
        // Create customer
        Customer customer = new Customer("John Doe", "123 Main Street");
        System.out.println("Customer: " + customer);

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

        // Print order summary
        System.out.println("Order Date: " + order.getDate());
        System.out.println("Order Status: " + order.getStatus());
        System.out.println("Sub Total: " + order.calcSubTotal());
        System.out.println("Tax: " + order.calcTax());
        System.out.println("Total: " + order.calcTotal());
        System.out.println("Total Weight: " + order.calcTotalWeight());

        // Cash payment
        Cash cash = new Cash(500f, 600f);
        System.out.println("Cash Tendered: " + cash.getCashTendered());
        System.out.println("Change: " + cash.getChange());

        // Check payment
        Check check = new Check(200f, "John Doe", "BANK123");
        System.out.println("Check Authorized: " + check.authorized());

        // Credit payment
        Credit credit = new Credit(300f, "John Doe", "VISA", new Date(System.currentTimeMillis() + 86400000L));
        System.out.println("Credit Authorized: " + credit.authorized());
    }
}