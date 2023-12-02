/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectProblems;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Sohel
 */
class Pair {
    int row,col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class problem_11953 {
    static int n;
    static boolean isValid(int row, int col){
        return row < n && col < n;
    }
    public static void bfs(char graph[][], boolean taken[][], int row, int col){
        int[][] directions = {{0,1},{1,0}};
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(row, col));
        taken[row][col] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int d[] : directions){
                int newRow = p.row + d[0];
                int newCol = p.col + d[1];
                
                if(isValid(newRow, newCol) && !taken[newRow][newCol] && graph[newRow][newCol] == 'x'){
                    q.add(new Pair(newRow, newCol));
                    taken[newRow][newCol] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        char graph[][];
        boolean taken[][];
        
        try {
            File file = new File("C:/Users/Sohel/Desktop/projectsProblems/problems_11953.txt");
            Scanner sc = new Scanner(file);
            int test = sc.nextInt();
            for(int t = 1; t <= test; t++){
                 n = sc.nextInt();
                
                graph = new char[n][n];
                taken = new boolean[n][n];
                
                for(int r = 0; r < n; r++){
                    for(int c = 0; c < n; c++){
                        graph[r][c] = sc.next().charAt(0);
                        taken[r][c] = false;
                    }
                }
                int count = 0;
                for(int r = 0; r < n; r++){
                    for(int c = 0; c < n; c++){
                        if(!taken[r][c] && graph[r][c] == 'x'){
                           bfs(graph, taken, r, c);
                           count++;
                        }
                    }
                }
                System.out.println("Case " + t + " : " + count);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
