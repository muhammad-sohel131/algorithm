/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Sohel
 */
public class SecondBestMST {

    class Edge implements Comparable<Edge> {

        int src, dest, weight;

        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    };
    int V, E;
    Edge edge[];
    int leader[];
    Edge[] result;

    SecondBestMST(int v, int e) {
        V = v;
        E = e;
        leader = new int[V];
        edge = new Edge[E];
        result = new Edge[V - 1];
        for (int i = 0; i < e; ++i) {
            edge[i] = new Edge();
        }
    }

    int Find(int n) {
        return leader[n];
    }

    void Union(int rootU, int rootV) {
        int newLeader;
        if (rootU < rootV) {
            newLeader = rootU;
            for (int i = 0; i < V; i++) {
                if (leader[i] == rootV) {
                    leader[i] = newLeader;
                }
            }
        } else {
            newLeader = rootV;

            for (int i = 0; i < V; i++) {
                if (leader[i] == rootU) {
                    leader[i] = newLeader;
                }
            }
        }
    }

    void KruskalMST() {

        int i;
        for (i = 0; i < result.length; i++) {
            result[i] = new Edge();
        }
        Arrays.sort(edge);
        for (i = 0; i < V; ++i) {
            leader[i] = i;
        }
        i = 0;
        for (int e = 0; e < edge.length; e++) {
            Edge next_edge = edge[e];

            int x = Find(next_edge.src);
            int y = Find(next_edge.dest);

            if (x != y) {
                result[i++] = next_edge;
                Union(x, y);
            }

        }
        
        int minimumCost = 0;
        for (i = 0; i < result.length; i++) {
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost of Spanning Tree " + minimumCost);
    }

    void secondMST() {
        int secondCost = Integer.MAX_VALUE;
        for (int t = 0; t < result.length; t++) {
            for (int k = 0; k < V; ++k) {
                leader[k] = k;
            }
            int sum = 0;
            int conected = 0;
            for (int e = 0; e < edge.length; e++) {
                Edge next_edge = edge[e];

                if (next_edge.dest == result[t].dest && next_edge.weight == result[t].weight) {
                    continue;
                }

                int x = Find(next_edge.src);
                int y = Find(next_edge.dest);

                if (x != y) {
                    sum += next_edge.weight;
                    Union(x, y);
                    conected++;
                }

            }
            
            if(conected != V - 1) continue;
            
            if (secondCost > sum) {
                secondCost = sum;
            }
        }
        System.out.println("Second Minimun Cost of Spanning Tree " + secondCost);
    }

    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(new File("C:/Users/Sohel/Desktop/input.txt"));
            int V = sc.nextInt();
            int E = sc.nextInt();

            SecondBestMST graph = new SecondBestMST(V, E);

            for (int i = 0; i < E; i++) {
                graph.edge[i].src = sc.nextInt();
                graph.edge[i].dest = sc.nextInt();
                graph.edge[i].weight = sc.nextInt();
            }
            graph.KruskalMST();
            graph.secondMST();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
