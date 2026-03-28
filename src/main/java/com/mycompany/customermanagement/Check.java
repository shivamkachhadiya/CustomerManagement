/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customermanagement;

public class Check extends Payment {
    private final String name;
    private final String bankID;

    public Check(float amount, String name, String bankID) {
        super(amount);
        this.name = name;
        this.bankID = bankID;
    }

    public boolean authorized() {
        return bankID != null && !bankID.isEmpty();
    }

    public String getName() { return name; }
    public String getBankID() { return bankID; }
}