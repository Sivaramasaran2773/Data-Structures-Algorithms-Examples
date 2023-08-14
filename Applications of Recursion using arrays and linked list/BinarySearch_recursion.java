package com.company;

import java.util.Scanner;
public class BinarySearch_recursion{
    int rec_bin_search(int my_arr[], int left, int right, int x){
        if (right >= left){
            int mid = (right + left)/2;
            if (my_arr[mid] == x)
                return mid;
            if (my_arr[mid] > x)
                return rec_bin_search(my_arr, left, mid - 1, x);
            return rec_bin_search(my_arr, mid + 1, right, x);
        }
        return -1;
    }
    public static void main(String args[]){
        BinarySearch_recursion my_object = new BinarySearch_recursion();
        System.out.print("Enter the required size of the array: ");
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int myArray[] = new int [size];
        System.out.println("Enter the elements of the array one by one ");
        for(int i=0; i<size; i++){
            myArray[i] = s.nextInt();
        }
        System.out.print("Enter the element to be searched: ");
        int target = s.nextInt();
        int len = myArray.length;
        int result = my_object.rec_bin_search(myArray, 0, len - 1, target);
        if (result == -1)
            System.out.println("The element is not present in the array");
        else
            System.out.println("The element has been found at index " + result);
    }
}
