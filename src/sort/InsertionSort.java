package sort;

import java.util.Scanner;

public class InsertionSort {
	
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
		for(int i=1; i<a.length; i++) {
			int j = i;
			while(j>0 && a[j-1]>a[j]) {
				int key = a[j];
				a[j] = a[j-1];
				a[j-1] = key;
				j--;
			}
			printArray(a);
			System.out.println();
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
