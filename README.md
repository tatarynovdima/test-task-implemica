### README: Task Descriptions and Solutions

---

## **Overview**
This project contains solutions to three algorithmic tasks designed to test problem-solving skills and coding proficiency. The solutions are implemented in Java, leveraging efficient algorithms and detailed comments to ensure clarity and maintainability.

---

## **Task Descriptions and Solutions**

### **Task 1: Counting Valid Parenthesis Combinations**
#### **Problem Description:**
Given \( N \), the number of pairs of parentheses, calculate the total number of valid combinations of opening and closing parentheses. A valid combination (correct bracket expression) is defined as:
1. Every opening parenthesis `(` has a corresponding closing parenthesis `)`.
2. Parentheses close in the correct order.

#### **Example:**
- For \( N = 1 \):  
  Valid combinations = `()`.  
  **Output**: 1
- For \( N = 2 \):  
  Valid combinations = `()()` and `(())`.  
  **Output**: 2

#### **Solution:**
The number of valid combinations is given by the *Catalan Number* for \( N \). Using dynamic programming:
1. Create an array `dp[]`, where `dp[i]` stores the number of valid combinations for \( i \) pairs of parentheses.
2. Use the recursive relationship:  
   \[
   dp[n] = \sum_{i=0}^{n-1} dp[i] \cdot dp[n-i-1]
   \]
3. Base case: \( dp[0] = 1 \), as there is one valid combination for zero pairs.
4. Compute \( dp[N] \) iteratively.

---

### **Task 2: Minimum Transportation Cost**
#### **Problem Description:**
Given a list of cities and direct connections between them with associated costs, determine the shortest transportation cost between specified pairs of cities.

#### **Input Format:**
- Number of test cases \( s \).
- For each test case:
  - Number of cities \( n \).
  - Each city's name and its neighbors with transportation costs.
  - Number of paths \( r \), followed by the pairs of source and destination cities.

#### **Output Format:**
For each source-destination pair, print the minimum cost.

#### **Example:**
**Input:**
```
1
4
gdansk
2
2 1
3 3
bydgoszcz
3
1 1
3 1
4 4
torun
3
1 3
2 1
4 1
warszawa
2
2 4
3 1
2
gdansk warszawa
bydgoszcz warszawa
```

**Output:**
```
3
2
```

#### **Solution:**
1. Represent cities and connections as a weighted graph.
2. Use Dijkstra's algorithm to compute the shortest path:
   - Maintain a priority queue to explore nodes with the smallest cumulative cost.
   - Track visited cities to avoid redundant calculations.
   - Update the minimum cost for neighbors of the current city.
3. Output the minimum cost for each specified source-destination pair.

---

### **Task 3: Sum of Digits in 100!**
#### **Problem Description:**
Calculate the sum of the digits in the factorial of 100 (\( 100! \)).

#### **Example:**
- \( 100! = 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000 \)
- Sum of digits = 648.  
**Output**: 648

#### **Solution:**
1. Use Java's `BigInteger` to calculate the factorial of 100.
2. Convert the result to a string to access individual digits.
3. Iterate over the string, summing the numeric value of each character.

---

## **How to Run the Code**
1. **Prerequisites:**
   - Java Development Kit (JDK) installed on your machine.
   - A code editor or terminal with Java support.

2. **Running the Code:**
   - Compile the `.java` files using the `javac` command:
     ```bash
     javac BracketExpressions.java ShortestPath.java FactorialSum.java
     ```
   - Execute the compiled files using the `java` command:
     ```bash
     java BracketExpressions
     java ShortestPath
     java FactorialSum
     ```

3. **Input:**
   - For Task 1: Enter \( N \) when prompted.
   - For Task 2: Provide the test case input as described in the problem.
   - For Task 3: No input is required.

4. **Output:**
   - Task 1: Number of valid parenthesis combinations.
   - Task 2: Minimum transportation costs for each specified pair of cities.
   - Task 3: Sum of the digits in \( 100! \).

---
