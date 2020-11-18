package dataStructures;

public class QueueUsingLinkedList {
	
	Node head;
	
	public class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void insert(int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
			return;
		}
		if(head.next == null) {
			head.next = node;
			return;
		}
		Node ptr = head;
		while(ptr.next!=null)
			ptr=ptr.next;
		ptr.next = node;
	}
	
	public void delete() {
		if(head == null) {
			System.out.println("Queue is empty.");
			return;
		}
		int data = head.data;
		head = head.next;
		System.out.println(data + " is deleted.");
	}
	
	public void print() {
		if(head == null) {
			System.out.println("Queue is empty.");
			return;
		}
		Node ptr = head;
		while(ptr!=null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	public static void main(String a[]) {
		QueueUsingLinkedList q = new QueueUsingLinkedList();
		q.insert(1);
		q.insert(2);
		q.insert(3);
		q.insert(56);
		q.print();
		q.delete();
		q.print();
	}
	
}
