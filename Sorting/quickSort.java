/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author Sohel
 */
public class quickSort {
    static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    static int partition(int arr[], int left, int right){
        int pivot = left;
        int bigIndex = left, smallIndex = right;
        
        while(bigIndex < smallIndex){
            while(bigIndex <= right && arr[bigIndex] <= arr[pivot]) bigIndex++;
            while(smallIndex >= left && arr[smallIndex] > arr[pivot]) smallIndex--;
            
            if(bigIndex < smallIndex){
                swap(arr, bigIndex, smallIndex);
            }
        }
        
        swap(arr,pivot,smallIndex);
        
        pivot = smallIndex;
        
        return pivot;
    }
    static void quickSort(int arr[], int left, int right){
        if(left < right){
            int p = partition(arr, left,right);
            quickSort(arr, left, p-1);
            quickSort(arr, p+1,right);
        }
    }
    public static void main(String[] args) {
        int arr[] = {80,20,30,90};
        quickSort(arr, 0, arr.length - 1);
        
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
