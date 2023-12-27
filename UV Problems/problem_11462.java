/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectProblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Sohel
 */
public class Problem_11462 {
    static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int partition(int arr[], int left, int right) {
        int pivot = left;
        int bigIndex = left, smallIndex = right;

        while (bigIndex < smallIndex) {
            while (bigIndex <= right && arr[bigIndex] <= arr[pivot]) {
                bigIndex++;
            }
            while (smallIndex >= left && arr[smallIndex] > arr[pivot]) {
                smallIndex--;
            }

            if (bigIndex < smallIndex) {
                swap(arr, bigIndex, smallIndex);
            }
        }

        if(pivot != smallIndex){
            swap(arr, pivot, smallIndex);
        }

        pivot = smallIndex;

        return pivot;
    }

    static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
    }

    public static void main(String[] args) {
        int arr[];
        int n;
        try {
            Scanner sc = new Scanner(new File("C:/Users/Sohel/Desktop/projectsProblems/problems_11462.txt"));
            n = sc.nextInt();
            while (n != 0) { 
                arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                
                quickSort(arr, 0, arr.length - 1);
                for(int i : arr){
                    System.out.print(i + " ");
                }
                System.out.println("");
                n = sc.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }
}
