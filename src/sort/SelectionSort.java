package sort;

import java.util.Scanner;

public class SelectionSort {
	
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
		for(int i=0; i<a.length-1; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[i]>a[j]) {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
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
