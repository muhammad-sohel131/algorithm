/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SubmissionCode;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Problem_10305 {
    static boolean visited[];
    static Stack<Integer> stack = new Stack();
   
    static void dfs(ArrayList<ArrayList<Integer>> graph, int i){
        visited[i] = true;
        for(int j : graph.get(i)){
            if(!visited[j]){
                dfs(graph,j);
            }
        }
        stack.push(i);
    }
    static void completeTasks(ArrayList<ArrayList<Integer>> graph){
        for(int i = 1; i < graph.size(); i++){
            if(!visited[i]){
                dfs(graph,i);
            }
        }
       
        
        while(!stack.isEmpty()){
            int i = stack.pop();
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph;
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        while(vertices != 0 || edges != 0){
            stack.clear();
            graph = new ArrayList();
            visited = new boolean[vertices + 1];
            
            for(int i = 0; i <= vertices; i++){
                graph.add(new ArrayList());
                visited[i] = false;
            }
            for(int i = 0; i < edges; i++){
                int src = sc.nextInt();
                int dest = sc.nextInt();
                graph.get(src).add(dest);
            }
            completeTasks(graph);
            
            vertices = sc.nextInt();
            edges = sc.nextInt();
        }
    }
}
