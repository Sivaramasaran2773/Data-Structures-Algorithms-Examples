package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort
{
    static void bubbleSort(int []arr, int n)
    {
        if (n == 1)
            return;
        int count = 0;
        for (int i=0; i<n-1; i++)
            if (arr[i] > arr[i+1])
            {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                count = count+1;
            }
        if (count == 0)
            return;
        bubbleSort(arr, n-1);
    }
    public static void main(String[] args)
    {
        System.out.print("Enter the required size of the array: ");
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int []arr = new int [size];
        System.out.println("Enter the elements of the array one by one ");
        for(int i=0; i<size; i++){
            arr[i] = s.nextInt();
        }

        bubbleSort(arr, arr.length);

        System.out.println("Sorted array : ");
        System.out.println(Arrays.toString(arr));
    }
}
