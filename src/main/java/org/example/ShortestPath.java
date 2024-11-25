package org.example;

import java.util.*;

/**
 * This program finds the shortest path between pairs of cities in a graph,
 * where each edge represents a transportation cost.
 *
 * Algorithm:
 * - Represent the cities as nodes and the connections as edges with weights.
 * - Use Dijkstra's algorithm to compute the shortest path between two cities.
 *
 * Input:
 * - Multiple test cases with city names, neighbors, and costs.
 * - For each test case, find the shortest paths for given pairs of cities.
 *
 * Output:
 * - Minimum transportation cost for each pair of cities.
 */
public class ShortestPath {
    // Class representing a city with its name and neighbors
    static class City {
        String name;
        List<Edge> neighbors = new ArrayList<>();
    }

    // Class representing an edge between cities with a cost
    static class Edge {
        int target; // Index of the target city
        int cost;   // Transportation cost to the target city

        Edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            // Read the number of cities
            int n = scanner.nextInt();

            // Map to store city names and their indices
            Map<String, Integer> cityIndices = new HashMap<>();
            City[] cities = new City[n];

            // Input the city data
            for (int i = 0; i < n; i++) {
                cities[i] = new City();
                cities[i].name = scanner.next(); // Read city name
                cityIndices.put(cities[i].name, i);

                // Read the number of neighbors
                int p = scanner.nextInt();
                for (int j = 0; j < p; j++) {
                    int neighbor = scanner.nextInt() - 1; // Neighbor index
                    int cost = scanner.nextInt();        // Transportation cost
                    cities[i].neighbors.add(new Edge(neighbor, cost));
                }
            }

            // Read the number of paths to find
            int r = scanner.nextInt();
            for (int i = 0; i < r; i++) {
                String source = scanner.next();       // Starting city
                String destination = scanner.next();  // Destination city

                // Find and print the shortest path cost
                System.out.println(findShortestPath(cities, cityIndices.get(source), cityIndices.get(destination)));
            }
        }
    }

    /**
     * Finds the shortest path between two cities using Dijkstra's algorithm.
     *
     * @param cities The array of cities (nodes in the graph)
     * @param source The index of the starting city
     * @param destination The index of the destination city
     * @return The minimum cost to reach the destination
     */
    private static int findShortestPath(City[] cities, int source, int destination) {
        // Priority queue for selecting the next city with the smallest cost
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0}); // Start with the source city

        // Distance array to track the shortest cost to each city
        int[] dist = new int[cities.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Visited array to avoid revisiting cities
        boolean[] visited = new boolean[cities.length];

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int city = current[0], cost = current[1];

            if (visited[city]) continue; // Skip already visited cities
            visited[city] = true;

            // Update the costs of neighboring cities
            for (Edge edge : cities[city].neighbors) {
                int newCost = cost + edge.cost;
                if (newCost < dist[edge.target]) {
                    dist[edge.target] = newCost;
                    pq.add(new int[]{edge.target, newCost});
                }
            }
        }

        return dist[destination]; // Return the shortest cost to the destination
    }
}
