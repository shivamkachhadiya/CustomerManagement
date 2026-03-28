/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customermanagement;
public class Item {
    private double shippingWeight;
    private String description;

    public Item(String description, double shippingWeight) {
        this.description = description;
        this.shippingWeight = shippingWeight;
    }

    public double getPriceForQuantity(int quantity) {
        return quantity * 10.0;
    }

    public double getTax() {
        return getPriceForQuantity(1) * 0.18;
    }

    public boolean inStock() {
        return shippingWeight > 0;
    }

    public double getShippingWeight() { return shippingWeight; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "Item[" + description + ", weight=" + shippingWeight + "]";
    }
}