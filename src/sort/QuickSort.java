package sort;

import java.util.Scanner;

public class QuickSort {
	
	private static Scanner s = new Scanner(System.in);
	
	private static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];
        int i = (low-1); // index of smaller element   
        System.out.println("Pivot is " + pivot + " in position " + high + "\ni=" + i + " (low-1), which is the index of smaller element");
        for (int j=low; j<high; j++) 
        {  
            if (arr[j] < pivot) 
            { 
                i++; 
  
                System.out.println("Current element arr[j]=" + arr[j] + " is smaller than the pivot(" + pivot + "), increment i and swap arr[i]=" + arr[i] + " and arr[j]=" + arr[j]);
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            }  else
                System.out.println("Current element arr[j]=" + arr[j] + " is greater than or equal the pivot(" + pivot + ")");
            System.out.println("i=" + i + " j=" + j + " low=" + low + " high=" + high);
            print(arr);
        } 
        
        i++;
        System.out.println("increment swap arr[i]=" + arr[i] + " and arr[high] (or pivot)=" + pivot); 
        int temp = arr[i]; 
        arr[i] = arr[high]; 
        arr[high] = temp; 
        System.out.println("i=" + i + " low=" + low + " high=" + high);
        print(arr);
        return i; 
    } 
	
	private static void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
        	System.out.println("\npartition(arr, low=" + low +", high=" + high +")");
            int pivotIndex = partition(arr, low, high); 
            System.out.println("pivotIndex=" + pivotIndex + "\n");
            System.out.println("sort(arr, low=" + low + ", pivotIndex-1 = " + (pivotIndex-1) + ")");
            sort(arr, low, pivotIndex-1); 
            System.out.println("\nsort(arr, pivotIndex+1 = " + (pivotIndex+1) + " high=" + high + ")");
            sort(arr, pivotIndex+1, high); 	
        } else {
        	System.out.println("low=" + low + " is greater than or equal to high=" + high);
        }
    } 
	
	private static void print(int[] a) {
		for(int i : a)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.print("Enter number of array elements : ");
		int a[] = new int[s.nextInt()];
		System.out.print("Enter array elements : ");
		for(int i=0; i<a.length; i++)
			a[i] = s.nextInt();
		sort(a, 0, a.length-1); 
	  
	    System.out.print("\nAfter sorting : "); 
	    print(a); 
	}

}
