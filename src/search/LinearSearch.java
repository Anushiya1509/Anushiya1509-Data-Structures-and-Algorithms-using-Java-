package search;

import java.util.Scanner;

public class LinearSearch {

	private static Scanner s = new Scanner(System.in);
	
	private static int[] getArrayElements() {
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
	
	private static int search(int[] a, int item) {
		for(int i=0; i<a.length; i++) 
			if(item == a[i]) 
				return i;
		return -1;
	}
	
	public static void main(String[] args) {
		int a[] = getArrayElements();
		System.out.println(search(a, 5));
	}

}
