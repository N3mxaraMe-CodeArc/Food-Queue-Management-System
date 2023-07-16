package com.example.w198756920223294;

import java.util.ArrayList;

public class FoodQueue {

    ArrayList<Customer> cashier = new ArrayList<>();
    private int size;



    public FoodQueue(int size) {
        this.cashier = new ArrayList<>();
        this.size = size;
    }

    public ArrayList<Customer> getCashier() {
        return cashier;
    }

    public void setCashier(ArrayList<Customer> cashier) {
        this.cashier = cashier;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFull(){
        return size == cashier.size();
    }


}
