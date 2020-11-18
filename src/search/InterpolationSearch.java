package search;

import java.util.Arrays;
import java.util.Scanner;

public class InterpolationSearch {
	
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
		Arrays.sort(a);
		System.out.println("After sorting : ");
		for(int i : a)
			System.out.println(i);
		return a;
	}
	
	private static int search(int a[]) {
		System.out.println("Enter item to search : ");
		int item = s.nextInt();
		int lb=0, ub=a.length-1;
		while(lb<=ub) {
			int mid = lb+(((ub-lb)/(a[lb]-a[ub]))*(item-a[lb]));
			System.out.println(mid + " " + a[mid]);
			if(a[mid]==item)
				return mid;
			if(a[mid]<item)
				lb = mid+1;
			else
				ub = mid-1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int a[] = getArrayElements();
		System.out.println(search(a));
	}

}
