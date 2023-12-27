/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SubmissionCode;


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int src, dest, cost;

    Edge(int src, int dest, int cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Problem_908 {
    static int n;
    static Queue<Edge> edges = new PriorityQueue<>();
    public static int[] leader;

    public static void union(int src, int dest) {
        int newLeader;
        if (src < dest) {
            newLeader = src;
            for (int i = 1; i <= n; i++) {
                if (leader[i] == dest) {
                    leader[i] = newLeader;
                }
            }
        } else {
            newLeader = dest;
            for (int i = 1; i <= n; i++) {
                if (leader[i] == src) {
                    leader[i] = newLeader;
                }
            }
        }
    }

    public static int findCost() {
        int newCost = 0;
        while (!edges.isEmpty()) {
            Edge e = edges.poll();
            int src = e.src;
            int dest = e.dest;

            if (leader[src] != leader[dest]) {
                newCost += e.cost;
                union(leader[src], leader[dest]);
            }
        }
        return newCost;
    }

    public static void main(String[] args) {
        boolean firstTime = true;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            int totalCost = 0;
            int i;
            leader = new int[n + 1];
            for (i = 1; i < n; i++) {
                leader[i] = i;
                int src = sc.nextInt();
                int dest = sc.nextInt();
                int cost = sc.nextInt();
                totalCost += cost;
            }
            leader[i] = i;
            int k = sc.nextInt();
            for (i = 0; i < k; i++) {
                int src = sc.nextInt();
                int dest = sc.nextInt();
                int cost = sc.nextInt();

                edges.add(new Edge(src, dest, cost));
            }
            int m = sc.nextInt();
            for (i = 0; i < m; i++) {
                int src = sc.nextInt();
                int dest = sc.nextInt();
                int cost = sc.nextInt();

                edges.add(new Edge(src, dest, cost));
            }
            if (!firstTime) {
                System.out.println();
            }
            firstTime = false;

            System.out.println(totalCost);
            int newCost = findCost();
            System.out.println(newCost);

            edges.clear();
        }
    }
}
