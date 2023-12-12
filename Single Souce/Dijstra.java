/*
    Print the shortest path from source to destination
*/

package com.mycompany.mavenproject2;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Sohel
 */
public class Diajstra {
    static int vertices;
    static int[] parents;
    
    public static void findPath(int src, int dest){
        if(parents[dest] != -1){
            findPath(src, parents[dest]);
        }
        System.out.print(dest + " ");
    }
    
    int minDistance(int dist[], Boolean sptSet[]){
        int min = Integer.MAX_VALUE, min_index = -1;
        for(int v = 0; v < vertices; v++){
            if(sptSet[v] == false && dist[v] <= min){
                min = dist[v];
                min_index = v;
            }
        }  
        return min_index;
    }
    
    
    void dijkstra(int graph[][], int src){
        int dist[] = new int[vertices];
        Boolean sptSet[] = new Boolean[vertices];
        
        for(int i = 0; i < vertices; i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        
        dist[src] = 0;
        
        for(int count = 0; count < vertices - 1; count++){
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            
            for(int v = 0; v < vertices; v++){
                if(!sptSet[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                    parents[v] = u;
                }
            }
        }
        
        
        for(int i = 0; i < vertices; i++){
            System.out.print("The path from " + 0 + " to " + i + " : ");
            findPath(0,i);
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        File file = new File("C:/Users/Sohel/Desktop/input.txt");
        int graph[][];
        try {
            Scanner sc = new Scanner(file);
            vertices = sc.nextInt();
            int edges = sc.nextInt();
            graph = new int[vertices][vertices];
            parents = new int[vertices];
            
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    graph[i][j] = 0;
                }
                parents[i] = -1;
            }
            
            for (int i = 0; i < edges; i++) {
                int first = sc.nextInt();
                int second = sc.nextInt();
                int value = sc.nextInt();
                
                graph[first][second] = value;
            }

            Diajstra d = new Diajstra();
            d.dijkstra(graph,0);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
