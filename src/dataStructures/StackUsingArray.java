package dataStructures;

public class StackUsingArray {
	
	int top;
	int maxSize;
	int[] a;

	public StackUsingArray(int maxSize) {
		top = -1;
		this.maxSize = maxSize;
		a = new int[maxSize];
	}
	
	public boolean isEmpty() {
		if(top == -1)
			return true;
		return false;
	}
	
	public boolean isFull() {
		if(top == maxSize-1)
			return true;
		return false;
	}
	
	public void push(int data) {
		if(!isFull()) {
			a[++top] = data;
			System.out.println(data + " is inserted.");
			return;
		}
		System.out.println("Stack is full.\nCannot insert " + data + " into the stack.");
	}
	
	public void pop() {
		if(!isEmpty()) {
			int data = a[top--];
			System.out.println(data + " is deleted.");
			return;
		}
		System.out.println("Stack is empty.\nCannot delete items.");
	}
	
	public void print() {
		if(!isEmpty()) {
			for(int i=0; i<=top; i++)
				System.out.print(a[i] + " ");
			System.out.println();
		}
	}
	
}
