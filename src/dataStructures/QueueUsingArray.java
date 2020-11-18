package dataStructures;

public class QueueUsingArray {
	int top;
	int maxSize;
	int[] a;

	public QueueUsingArray(int maxSize) {
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
			int data = a[0];
			for(int i=0; i<top; i++)
				a[i]=a[i+1];
			top--;
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

	public static void main(String[] args) {
		QueueUsingArray q = new QueueUsingArray(100);
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(77);
		q.print();
		q.pop();
		q.print();
	}

}
