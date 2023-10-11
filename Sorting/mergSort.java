/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author Sohel
 */

public class mergSort {
    static void merge(int arr[], int left, int mid, int right){
        int leftArr[] = new int[mid - left + 1];
        int rightArr[] = new int[right - mid];
        
        int leftSize = 0;
        int rightSize = 0;
        
        for(int i = left; i <= mid; i++){
            leftArr[leftSize++] = arr[i];
        }
        
        for(int i = mid + 1; i <= right; i++){
            rightArr[rightSize++] = arr[i];
        }
        
        int leftIndex = 0;
        int rightIndex = 0;
        
        int i = left;
        while(leftIndex < leftSize && rightIndex < rightSize){
            if(leftArr[leftIndex] < rightArr[rightIndex]){
                arr[i] = leftArr[leftIndex++];
            }else {
                arr[i] = rightArr[rightIndex++];
            }
            i++;
        }
        
        while(leftIndex < leftSize){
            arr[i] = leftArr[leftIndex++];
            i++;
        }
        
        while(rightIndex < rightSize){
            arr[i] = rightArr[rightIndex++];
            i++;
        }
    }
    static void divide(int arr[], int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            divide(arr, left, mid);
            divide(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    static void doSort(int[] arr){
        int length = arr.length;
        divide(arr, 0, length - 1);
    }
    public static void main(String[] args) {
        int[] arr = {2,5,3,20,10,-10,100,-20,3};
        doSort(arr);
        
        for(int i : arr){
            System.out.println(i + " ");
        }
    }
  
}
