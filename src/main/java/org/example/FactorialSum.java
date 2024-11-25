package org.example;

import java.math.BigInteger;

/**
 * This program calculates the sum of the digits in the factorial of 100 (100!).
 *
 * Algorithm:
 * - Compute the factorial of 100 using BigInteger (to handle large numbers).
 * - Convert the resulting number into a string to access its digits.
 * - Compute the sum of all digits in the number.
 *
 * Output: The sum of the digits in 100!
 */
public class FactorialSum {
    public static void main(String[] args) {
        // Use BigInteger to calculate factorial of 100
        BigInteger factorial = BigInteger.ONE;

        // Compute 100! (factorial of 100)
        for (int i = 2; i <= 100; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        // Convert the factorial result to a string
        String digits = factorial.toString();

        // Sum up all digits in the factorial
        int sum = 0;
        for (char digit : digits.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }

        // Print the sum of the digits
        System.out.println("Sum of digits in 100! is: " + sum);
    }
}
