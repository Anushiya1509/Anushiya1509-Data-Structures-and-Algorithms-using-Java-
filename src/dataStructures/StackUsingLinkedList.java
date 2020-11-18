package dataStructures;

public class StackUsingLinkedList {
	
	public Node root;
	
	public class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
		}
		
	}
	
	public boolean isEmpty() {
		if(root == null)
			return true;
		return false;
	}
	
	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = root;
		root = newNode;
		System.out.println(data + " is inserted.");
	}
	
	public void pop() {
		if(!isEmpty()) {
			int deleteItem = root.data;
			root = root.next;
			System.out.println(deleteItem + " is deleted.");
			return;
		}
		System.out.println("Stack is empty. Cannot pop elements.");
	}
	
	public void print() {
		if(isEmpty())
			System.out.println("Stack is empty.");
		else
			print(root);
	}
	
	private void print(Node root) {
		if(root == null)
			return;
		if(root!=null) 
			print(root.next);
		System.out.println(root.data + " ");
	}

}
