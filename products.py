package com.company;

public class Main {
    /*я, если честно, больше кушала, чем делала*/
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] str = scan.split(" ");
        TreeMap<String, Integer> products = new TreeMap<>();

        products.put("paper",10);
        if (products.containsKey("paper")) {
            int quantity += 5;
            products.put("paper", quantity);
        }

    }
}
