
package projectProblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Sohel
 */
public class Problems_10305 {
    static boolean visited[];
    static Stack<Integer> stack = new Stack();
        
    static void dfs(ArrayList<ArrayList<Integer>> graph, int i){
        visited[i] = true;
        
        for(int j : graph.get(i)){
            if(!visited[j]){
                dfs(graph,j);
            }
        }
        stack.push(i);  //when all the adjacent node are visited
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
        try{
            Scanner sc = new Scanner(new File("C:/Users/Sohel/Desktop/projectsProblems/problems_10305.txt"));
            
            int vertices = sc.nextInt();
            int edges = sc.nextInt();
            
            while(vertices != 0 || edges != 0){
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
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
}
