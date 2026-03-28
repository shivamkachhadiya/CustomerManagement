package com.mycompany.customermanagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class CustomerManagementTest {

    // Test 1: Customer name and address
    @Test
    public void testCustomerDetails() {
        Customer c = new Customer("John Doe", "123 Main Street");
        assertEquals("John Doe", c.getName());
        assertEquals("123 Main Street", c.getAddress());
    }

    // Test 2: Item in stock
    @Test
    public void testItemInStock() {
        Item item = new Item("Laptop", 2.5);
        assertTrue(item.inStock());
    }

    // Test 3: Order subtotal calculation
    @Test
    public void testOrderSubTotal() {
        Customer c = new Customer("Alice", "456 Park Ave");
        Item item = new Item("Phone", 1.0);
        OrderDetail detail = new OrderDetail(3, "taxable", item);
        Order order = new Order(c);
        order.addOrderDetail(detail);
        assertEquals(30.0, order.calcSubTotal(), 0.01);
    }

    // Test 4: Tax calculation
    @Test
    public void testOrderTax() {
        Customer c = new Customer("Bob", "789 Lake Rd");
        Item item = new Item("Tablet", 1.5);
        OrderDetail detail = new OrderDetail(2, "taxable", item);
        Order order = new Order(c);
        order.addOrderDetail(detail);
        assertEquals(3.6, order.calcTax(), 0.01);
    }

    // Test 5: Cash payment change
    @Test
    public void testCashPaymentChange() {
        Cash cash = new Cash(400f, 500f);
        assertEquals(100f, cash.getChange(), 0.01f);
    }

    // Test 6: Check authorization
    @Test
    public void testCheckAuthorization() {
        Check check = new Check(200f, "John", "BANK123");
        assertTrue(check.authorized());
    }

    // Test 7: Credit card authorization
    @Test
    public void testCreditAuthorization() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000L);
        Credit credit = new Credit(300f, "John", "VISA", futureDate);
        assertTrue(credit.authorized());
    }
}