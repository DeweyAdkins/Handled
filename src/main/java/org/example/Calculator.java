package org.example;

public class Calculator {


    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Parameter must be a non-negative number.");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }


    public static int binomialCoefficient(int n, int k) {
        if (n < 0 || k < 0 || k > n) {
            throw new IllegalArgumentException("Parameters must be non-negative and the subset size must not exceed the set size.");
        }
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static void main(String[] args) {
        try {

            Person person = new Person("John Doe", 25);
            System.out.println(person);


            System.out.println("Factorial of 5: " + factorial(5)); // Output: 120
            System.out.println("Binomial coefficient (5, 2): " + binomialCoefficient(5, 2)); // Output: 10


        } catch (IllegalArgumentException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}

