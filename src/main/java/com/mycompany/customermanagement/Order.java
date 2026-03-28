package com.mycompany.customermanagement;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class Order {
    private Date date;
    private String status;
    private Customer customer;
    private List<OrderDetail> orderDetails;
    private List<Payment> payments;

    public Order(Customer customer) {
        this.customer = customer;
        this.date = new Date();
        this.status = "PENDING";
        this.orderDetails = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public void addOrderDetail(OrderDetail detail) {
        orderDetails.add(detail);
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public double calcSubTotal() {
        double total = 0;
        for (OrderDetail d : orderDetails) total += d.calcSubTotal();
        return total;
    }

    public double calcTax() {
        double tax = 0;
        for (OrderDetail d : orderDetails) tax += d.calcTax();
        return tax;
    }

    public double calcTotal() {
        return calcSubTotal() + calcTax();
    }

    public double calcTotalWeight() {
        double weight = 0;
        for (OrderDetail d : orderDetails) weight += d.calcWeight();
        return weight;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Customer getCustomer() { return customer; }
    public Date getDate() { return date; }
}