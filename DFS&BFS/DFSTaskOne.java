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
public class DFS {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList();
    
    public static void dfs(int i){
        System.out.print(i + " ");
        visited[i] = true;
        ArrayList<Integer> arr = graph.get(i);
        
        for(int value : arr){
            if(!visited[value]){
                dfs(value);
            }
        }
    }
    public static void main(String[] args) {
       File file = new File("C:/Users/Sohel/Desktop/dfs.txt");
       try{
           Scanner sc = new Scanner(file);
           int vertices = sc.nextInt();
           int edges = sc.nextInt();
           
           visited = new boolean[vertices];
           for(int i = 0; i < vertices; i++){
               graph.add(new ArrayList());
               visited[i] = false;
           }
           
           for(int i = 0; i < edges; i++){
               int first = sc.nextInt();
               int second = sc.nextInt();
               
               graph.get(first).add(second);
               graph.get(second).add(first);
           }
           for(int i = 0; i < vertices; i++){
               if(!visited[i]){
                   dfs(i);
               }
           }
       }catch(Exception e){
           System.out.println(e);
       }
    }
}
