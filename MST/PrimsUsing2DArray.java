package com.mycompany.mavenproject2;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Sohel
 */
public class Prims {
    
    static int vertices;
    
    int minKey(int key[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        
        for (int v = 0; v < vertices; v++) {
            
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }
    
    void printMST(int parent[], int graph[][]) {
        
        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i + " => " + graph[i][parent[i]]);
        }
        
    }
    
    void primMST(int graph[][]) {
        
        int parent[] = new int[vertices];
        
        int key[] = new int[vertices];
        
        Boolean mstSet[] = new Boolean[vertices];
        
        for (int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        
        key[0] = 0;
        parent[0] = -1;
        
        for (int count = 0; count < vertices; count++) {
            
            int u = minKey(key, mstSet);
            
            mstSet[u] = true;
            
            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        
        printMST(parent, graph);
    }
    
    public static void main(String[] args) {
        File file = new File("C:/Users/Sohel/Desktop/prims.txt");
        int graph[][];
        try {
            Scanner sc = new Scanner(file);
            vertices = sc.nextInt();
            int edges = sc.nextInt();
            graph = new int[vertices][vertices];
            
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    graph[i][j] = 0;
                }
            }
            
            for (int i = 0; i < edges; i++) {
                int first = sc.nextInt();
                int second = sc.nextInt();
                int value = sc.nextInt();
                
                graph[first][second] = value;
                graph[second][first] = value;
            }

            /* printing the graph
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println("");
            }*/
            
            Prims p = new Prims();
            p.primMST(graph);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
}
