/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labReport.two;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Sohel
 */
public class detectCycle {
    public static void main(String[] args) {
        File file = new File("C:/Users/Sohel/Desktop/cycle.txt");
       
        Scanner sc;
        int vertices = 0,edges, start=0;
        int matrix[][] = new int[0][0];
        try{
            sc = new Scanner(file);
            vertices = sc.nextInt();
            edges = sc.nextInt();
            
            matrix = new int[vertices][vertices];
            for(int i = 0; i < edges; i++){
                int first = sc.nextInt();
                int second = sc.nextInt();
                matrix[first][second] = 1;
            }
            
            start = sc.nextInt();
            
        }catch(IOException e){
            System.out.println(e);
        }
        
        int visited[] = new int[vertices];
        int level[] = new int[vertices];
        boolean cycle = false;
        for(int i = 0; i < vertices; i++) {
            visited[i] = 0;
        }
        
        visited[start] = 1;
        level[start] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            int parent = queue.poll();
            for(int i = 0; i < vertices; i++){
                if(matrix[parent][i] == 1 && visited[i] == 2){
                    cycle = true;
                }
                if(matrix[parent][i] == 1 && visited[i] == 0){
                    queue.add(i);
                    level[i] = level[parent] + 1;
                    visited[i] = 1;
                }
            }
            visited[parent] = 2;
        }
        
        if(cycle){
            System.out.println("This graph has cycle");
        }else {
            System.out.println("This graph doesn't have cycle");
        }
    }
}
