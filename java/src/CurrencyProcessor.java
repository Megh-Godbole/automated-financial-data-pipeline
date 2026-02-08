package com.pipeline;

public class CurrencyProcessor {

    public static double convert(double amount, double rate) {
        return amount * rate;
    }

    public static void main(String[] args) {
        double converted = convert(100, 1.35);
        System.out.println("[Java] 100 USD = " + converted + " CAD");
    }
}
