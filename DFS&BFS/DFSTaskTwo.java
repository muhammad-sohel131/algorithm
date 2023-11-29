/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labReport.two;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sohel
 */
public class SoruceToDestinatin {
    static boolean[] visited;
    static int[] parents;
    static int source;
    static int dest;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList();
    
    public static void findPath(int src, int dest){
        if(parents[dest] != -1){
            findPath(src, parents[dest]);
        }
        System.out.print(dest + " ");
    }
    
    public static void dfs(int i){
        visited[i] = true;
        ArrayList<Integer> arr = graph.get(i);
        
        for(int value : arr){
            if(!visited[value]){
                parents[value] = i;
                dfs(value);
            }
        }
    }
    public static void main(String[] args) {
       File file = new File("C:/Users/Sohel/Desktop/path.txt");
       try{
           Scanner sc = new Scanner(file);
           int vertices = sc.nextInt();
           int edges = sc.nextInt();
           
           visited = new boolean[vertices];
           parents = new int[vertices];
           for(int i = 0; i < vertices; i++){
               graph.add(new ArrayList());
               visited[i] = false;
               parents[i] = -1;
           }
           
           for(int i = 0; i < edges; i++){
               int first = sc.nextInt();
               int second = sc.nextInt();
               
               graph.get(first).add(second);
               graph.get(second).add(first);
           }
           source = sc.nextInt();
           dest = sc.nextInt();
           
           for(int i = source; i < vertices; i++){
               if(!visited[i]){
                   dfs(i);
               }
           }
           
           for(int i : parents){
               System.out.print(i + " ");
           }
           System.out.println("");
           findPath(source, dest);
       }catch(Exception e){
           System.out.println(e);
       }
    }
}
