package sort;

import java.util.Scanner;

public class HeapSort {
	
	private static Scanner s = new Scanner(System.in);
	
	private static void heapify(int arr[], int n, int nodeIndex)
	{
		System.out.print("In heapify : ");
		print(arr);
    	System.out.println("nodeIndex: " + arr[nodeIndex] + " at " + nodeIndex);
	    int largest = nodeIndex;
	    int leftChild = 2*nodeIndex + 1;
	    int rightChild = 2*nodeIndex + 2;
	    // if left child is larger than root
	    if (leftChild < n && arr[leftChild] > arr[largest]) {
	        largest = leftChild;
		    System.out.println("leftchild: " + arr[leftChild] + " at " + leftChild);
	    }
	 
	    // if right child is larger than largest so far
	    if (rightChild < n && arr[rightChild] > arr[largest]) {
	        largest = rightChild;
		    System.out.println("rightChild: " + arr[rightChild] + " at " + rightChild);
	    }

    	System.out.println("largest: " + arr[largest] + " at " + largest);
	    // if largest is not root
	    if (largest != nodeIndex)
	    {
	    	int t = arr[nodeIndex];
	    	arr[nodeIndex] = arr[largest];
	    	arr[largest] = t;
	 
	        // recursively heapify the affected sub-tree
	        heapify(arr, n, largest);
	    }
	}

	private static void heapSort(int arr[], int n)
	{
		System.out.println("n=" + n);
	    // build heap (rearrange array)
		// height of the tree is n/2 +1
		// As index starts from 0, height is n/2
	    for (int i = n / 2 - 1; i >= 0; i--)
	        heapify(arr, n, i);
	    System.out.print("After building heap : ");
	    print(arr);
	    // one by one extract an element from heap
	    for (int i=n-1; i>0; i--)
	    {	
	        // move current root to end
	    	System.out.print("Swaping arr[i=" + i + "]=" + arr[i] + " and arr[0]=" + arr[0] + " : ");
	    	int t = arr[0];
	    	arr[0] = arr[i];
	    	arr[i] = t;
	    	print(arr);
	        // call max heapify on the reduced heap
	        heapify(arr, i, 0);
	        System.out.println("After deleting arr[i=" + i + "]=" + arr[i] + " : ");
	        print(arr);
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
		heapSort(a, a.length);
		System.out.print("After sorting : ");
		print(a);
	}

}
