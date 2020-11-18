package sort;

import java.util.Scanner;

public class BubbleSort {
	
	private static Scanner s = new Scanner(System.in);
	
	private static int[] getArray() {
		System.out.println("Enter array length : ");
		int n = s.nextInt();
		s.nextLine();
		int a[] = new int[n];
		System.out.println("Enter array elements : ");
		for(int i=0; i<n; i++)
			a[i] = s.nextInt();
		s.nextLine();
		return a;
	}
	
	private static int[] sort(int a[]) {
		boolean sorted = true;
		for(int i=0; i<a.length-1; i++) {
			sorted = true;
			for(int j=0; j<a.length-1-i; j++) 
				if(a[j]>a[j+1]) {
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
					sorted = false;
				}
			printArray(a);
			System.out.println();
			if(sorted)
				break;
		}
		return a;
	}
	
	private static void printArray(int a[]) {
		for(int i : a)
			System.out.println(i);
	}
	
	public static void main(String[] args) {
		int a[] = getArray();
		sort(a);
		System.out.println("After sorting : ");
		printArray(a);
	}

}
