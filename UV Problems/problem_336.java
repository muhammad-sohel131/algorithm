/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectProblems;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Sohel
 */
public class Problem_336 {
    static Map<Integer, Boolean> visited = new HashMap();
    static int count = 0;
    static void initializeVisitedMap(Map<Integer, ArrayList<Integer>> graph){
        Set<Integer> keys = graph.keySet();
        for(Integer key : keys){
            visited.put(key, false);
        }
        count = 0;
    }
    static void findNodes(Map<Integer, ArrayList<Integer>> graph , int start, int ttl){
        ttl--;
        count++;
        visited.put(start, true);
        
        if(ttl >= 0){
            ArrayList<Integer> adj = graph.get(start);
            for(int node : adj){
                if(visited.get(node) == false){
                    findNodes(graph,node,ttl);
                }
            }
        }
    }
    static void addEdge(Map<Integer, ArrayList<Integer>> graph, int src, int dest){
        if(graph.containsKey(src)){
            graph.get(src).add(dest);
        }else {
            ArrayList<Integer> arr = new ArrayList();
            arr.add(dest);
            graph.put(src, arr);
        }
        
        if(graph.containsKey(dest)){
            graph.get(dest).add(src);
        }else {
            ArrayList<Integer> arr = new ArrayList();
            arr.add(src);
            graph.put(dest, arr);
        }
    }
    public static void main(String[] args) {
       
        File file = new File("C:/Users/Sohel/Desktop/projectsProblems/problems_336.txt");
        int edges;
        Map<Integer, ArrayList<Integer>> graph = new HashMap();
        int c = 0; 
        try{
            Scanner sc = new Scanner(file);
            edges = sc.nextInt();
            
            do{
                graph.clear();
                visited.clear();
                for(int i = 0; i < edges; i++){
                    int src = sc.nextInt();
                    int dest = sc.nextInt();
                    addEdge(graph, src, dest);
                }
                
                while(true){
                    
                    int start = sc.nextInt();
                    int ttl = sc.nextInt();
                    
                    if(start == 0 && ttl == 0){
                        break;
                    }
                    
                    initializeVisitedMap(graph);
                    findNodes(graph, start, ttl);
                    c++;
                    System.out.println("Case " + c + " : " + (graph.size() - count) +" nodes not reachable from node " + start +" with TTL = " + ttl + ".");
                }
                edges = sc.nextInt();
            }while(edges != 0);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
