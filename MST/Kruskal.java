
package com.mycompany.mavenproject2;

/**
 *
 * @author Sohel
 */
import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.FileNotFoundException;

public class Kruskal {
    // A class to represent a graph edge

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

    Kruskal(int v, int e) {
        V = v;
        E = e;
        leader = new int[V];
        edge = new Edge[E];
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

        Edge[] result = new Edge[V - 1];

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
        System.out.println("Following are the edges in the constructed MST"
        );
        int minimumCost = 0;
        for (i = 0; i < result.length; i++) {
            System.out.println(result[i].src + " -> " + result[i].dest + " == "
                    + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree " + minimumCost);
    }

    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(new File("C:/Users/Sohel/Desktop/input.txt"));
            int V = sc.nextInt();
            int E = sc.nextInt();

            Kruskal graph = new Kruskal(V, E);

            for (int i = 0; i < E; i++) {
                graph.edge[i].src = sc.nextInt();
                graph.edge[i].dest = sc.nextInt();
                graph.edge[i].weight = sc.nextInt();
            }
            graph.KruskalMST();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
