package org.example;

import java.util.Scanner;

/**
 * This program calculates the number of valid parenthesis combinations
 * (correct bracket expressions) for a given number of pairs of parentheses (N).
 *
 * Algorithm:
 * - Use dynamic programming to compute the number of valid combinations.
 * - The formula is based on the recursive relationship:
 *   dp[n] = sum(dp[i] * dp[n - i - 1]) for i from 0 to n-1
 * - The base case is dp[0] = 1 (one valid combination for zero pairs).
 *
 * Input: N (non-negative integer)
 * Output: Number of valid bracket expressions for N pairs
 */
public class BracketExpressions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of pairs of parentheses
        System.out.print("Enter N (number of pairs): ");
        int N = scanner.nextInt();

        // Dynamic programming array to store the number of valid expressions
        long[] dp = new long[N + 1];

        // Base case: 1 valid expression for 0 pairs of parentheses
        dp[0] = 1;

        // Calculate the number of valid expressions for each number of pairs
        for (int n = 1; n <= N; n++) {
            for (int i = 0; i < n; i++) {
                dp[n] += dp[i] * dp[n - i - 1]; // Combine sub-problems
            }
        }

        // Output the result
        System.out.println("Number of valid expressions: " + dp[N]);
    }
}
