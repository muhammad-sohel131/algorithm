/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dynamic_Programming;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Sohel
 */
public class Napsack_01 {
    static int path[][];
    static int wt[];
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    static void printPath(int row, int col){
        if(row == 0 || col == 0){
            return;
        }
        if(path[row][col] == 1){
            int newRow = row - 1;
            int newCol = col - wt[row - 1];
            printPath(newRow, newCol);
            
            System.out.print(row + " ");
        }else {
            int newRow = row - 1;
            int newCol = col;
            printPath(newRow, newCol);
        }
    }
    static int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int P[][] = new int[n + 1][W + 1];
        path = new int[n + 1][W+1];

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    P[i][w] = 0;
                    path[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    if(val[i - 1] + P[i - 1][w - wt[i - 1]] > P[i - 1][w]){
                        path[i][w] = 1;
                    }else {
                        path[i][w] = 0;
                    }
                    P[i][w] = max(val[i - 1] + P[i - 1][w - wt[i - 1]], P[i - 1][w]);
                } else {
                    P[i][w] = P[i - 1][w];
                    path[i][w] = 0;
                }
            }
        }
        return P[n][W];
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("C:/Users/Sohel/Desktop/daynamic/knapsack.txt"));
            int n = sc.nextInt();
            int W = sc.nextInt();
            int val[] = new int[n];
            wt = new int[n];

            for (int i = 0; i < n; i++) {
                val[i] = sc.nextInt();
                wt[i] = sc.nextInt();
            }

            System.out.println("Maximum total profit = " + knapSack(W, wt, val, n));
            System.out.print("We have taken : ");
            printPath(n, W);
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
