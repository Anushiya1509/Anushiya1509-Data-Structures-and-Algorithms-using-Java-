package dataStructures;

public class SortedLinkedList {
	Node head;
	class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public void insert(int element) {
		Node newNode = new Node(element);
		if(head == null) 
			head = newNode;
		else if(head.data >= newNode.data) {
			newNode.next = head;
			head = newNode;
		}
		else {
			Node ptr = head;
			while(ptr.next != null && ptr.next.data < element) 
				ptr = ptr.next;
			if(ptr.next == null) {
				ptr.next = newNode;
			}
			else {
				newNode.next = ptr.next;
				ptr.next = newNode;
			}
		}
	}
	
	public void delete(int data) {
		if(head == null) {
			System.out.println("List is empty.");
			return;
		}
		if(head.data == data) {
			head = head.next;
			System.out.println(data + " is deleted.");
			return;
		}
		Node ptr = head.next, pptr = head;
		while(ptr!=null && ptr.data!=data) {
			if(ptr.data > data) {
				System.out.println(data + " is not found in the list.");
				return;
			}
			pptr = ptr;
			ptr = ptr.next;
		}
		if(ptr == null) {
			System.out.println(data + " is not found in the list.");
			return;
		}
		if(ptr.data == data) {
			pptr.next = ptr.next;
			System.out.println(data + " is deleted.");
			return;
		}
	}
	
	public void print() {
		if(head == null) {
			System.out.println("List is empty.");
			return;
		}
		Node ptr = head;
		while(ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	public static void main(String[] args) {
		SortedLinkedList sll = new SortedLinkedList();
		sll.insert(3);
		sll.insert(5);
		sll.insert(2);
		sll.insert(1);
		sll.insert(4);
		sll.insert(0);
		sll.insert(-1);
		sll.insert(-4);
		sll.insert(-3);
		sll.insert(-5);
		sll.insert(-2);
		sll.print();
		sll.delete(-9);
		sll.delete(5);
		sll.print();
		sll.delete(2);
		sll.print();
		sll.delete(-5);
		sll.print();
		sll.delete(-2);
		sll.print();
		sll.delete(4);
		sll.print();
		sll.delete(-4);
		sll.print();
		sll.delete(-3);
		sll.print();
		sll.delete(3);
		sll.print();
		sll.delete(1);
		sll.print();
		sll.delete(-1);
		sll.print();
		sll.delete(0);
		sll.print();
		sll.insert(999);
		sll.print();
	}

}
