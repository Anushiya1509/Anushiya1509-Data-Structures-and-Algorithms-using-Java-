package sort;

import java.util.Scanner;

public class MergeSort {
	
	private static Scanner s = new Scanner(System.in);
	
	private static void merge(int a[], int start, int mid, int end) {
		int arr[] = new int[a.length];
		int l = 0;
		int l1 = start;
		int l2 = mid + 1;
		while(l1<=mid && l2<=end)
			if(a[l1]<a[l2]) 
				arr[l++] = a[l1++];
			else
				arr[l++] = a[l2++];
		while(l1<=mid)
			arr[l++] = a[l1++];
		while(l2<=end)
			arr[l++] = a[l2++];
		for(int p=end; p>=start; p--)
			a[p] = arr[--l];
		System.out.print("a : ");
		print(a);
	}
	
	private static void mergeSort(int a[], int start, int end)
	{
	    if(start < end)
	    {
	    	int mid = (start + end) / 2;
	        mergeSort(a, start, mid);
	        mergeSort(a, mid+1, end);
	        merge(a, start, mid, end);
	    }
	}
	
	private static void print(int[] a) {
		for(int i : a)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("Enter array length : ");
		int[] a = new int[s.nextInt()];
		System.out.println("Enter array elements : ");
		for(int i=0; i<a.length; i++)
			a[i] = s.nextInt();
		mergeSort(a, 0, a.length-1);
		System.out.print("After sorting : ");
		print(a);
	}

}
