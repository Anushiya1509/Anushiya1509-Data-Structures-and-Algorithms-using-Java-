package dataStructures;

import java.util.Scanner;

public class LinkedList {
	
	Node head, loc, ploc, pploc;
	
	private static Scanner s = new Scanner(System.in);
	private static boolean quit = false;
	
	public class Node{
		
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
		
		Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
		
	}
	
	public void insertFirst(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void insertLast(int data) {
		if(head == null)
			head = new Node(data);
		else {
			Node ptr = head;
			while(ptr.next != null)
				ptr = ptr.next;
			ptr.next = new Node(data);
		}
	}
	
	public void insertBefore(int data, int element) {
		find(element);
		if(loc == null)
			System.out.println("\nError : " + element + " is not found in the list.\n");
		else if(ploc == null) {
			System.out.println(element + " is the start element.");
			Node node = new Node(data, head);
			head = node;
		}
		else {
			Node node = new Node(data, loc);
			ploc.next = node;
			System.out.println(data + " is inserted before " + element + ".");
		}
	}	
	
	public void insertAfter(int data, int element) {
		find(element);
		if(loc == null)
			System.out.println("\nError : " + element + " is not found in the list.\n");
		else {
			Node node = new Node(data, loc.next);
			loc.next = node;
			System.out.println(data + " is inserted after " + element + ".");
		}
	}
	
	public int deleteFirst() {
		int data = head.data;
		head = head.next;
		return data;
	}
	
	public int deleteLast() {
		if(head.next == null) {
			int data = head.data;
			head = null;
			return data;
		}
		Node pptr = null, ptr = head;
		while(ptr.next != null) {
			pptr = ptr;
			ptr = ptr.next;
		}
		pptr.next = null;
		return ptr.data;
	}
	
	public int deleteAfter(int element) {
		find(element);
		if(loc == null) {
			System.out.println("\nError : " + element + " is not found in the list.");
			return -1;
		}
		else if(loc.next == null) {
			System.out.println("\nError : " + element + " is the last element.");
			return -1;
		}
		int data = loc.next.data;
		loc.next = loc.next.next;
		return data;
	}
	
	public int deleteBefore(int element) {
		find(element);
		if(loc == null) {
			System.out.println("\nError : " + element + " is not found in the list.");
			return -1;
		}
		else if(ploc == null) {
			System.out.println("\nError : " + element + " is the first element.");
			return -1;
		}
		else if(pploc == null) {
			int data = ploc.data;
			head = loc;
			return data;
		}
		int data = ploc.data;
		pploc.next = ploc.next;
		return data;
	}
	
	public void print() {
		Node ptr = head;
		while(ptr!=null) {
			System.out.println(ptr.data + " ");
			ptr = ptr.next;
		}
	}
	
	public void find(int data) {
		if(head.data == data) {
			loc = head;
			ploc = null;
			pploc = null;
		}else if(head.next.data == data){ 
			loc = head.next;
			ploc = head;
			pploc = null;
		}else{
			Node ptr=head.next.next, pptr=head.next, ppptr=head;
			while(ptr!=null && ptr.data!=data) {
				ppptr = pptr;
				pptr = ptr;
				ptr = ptr.next;
			}
			loc = ptr;
			ploc = pptr;
			pploc = ppptr;
		}
	}
	
	public int deleteItem(int data) {
		find(data);
		if(loc == null) {
			System.out.println("\nError : " + data + " is not found in the list...\n");
			return -1;
		}
		if(ploc == null) {
			System.out.println(data + " is the start element...");
			int item = head.data;
			head = head.next;
			return item;
		}
		int item = loc.data;
		ploc.next = loc.next;
		return item;
	}
	
	public static void instructions() {
		System.out.println("1-Insertion\n2-Deletion\n3-Print List\n0-Quit\nEnter your choice : ");
	}
	
	public static void insertion() {
		System.out.println("1-Insert first\n2-Insert last\n3-Insert before\n4-Insert after\nEnter your choice : ");
	}
	
	public static void deletion() {
		System.out.println("1-Delete first\n2-Delete last\n3-Delete before\n4-Delete after\n5-Delete item\nEnter your choice : ");
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		while(!quit) {
			int data, element;
			instructions();
			switch(s.nextInt()) {
			
			case 1:
				insertion();
				switch(s.nextInt()) {
				
				case 1:
					System.out.print("\nEnter data to insert at first : ");
					data = s.nextInt();
					list.insertFirst(data);
					System.out.println(data + " is inserted at first\n");
					break;
				case 2:
					System.out.print("\nEnter data to insert at last : ");
					data = s.nextInt();
					list.insertLast(data);
					System.out.println(data + " is inserted at last\n");
					break;
				case 3:
					if(list.head == null) {
						System.out.println("\nError : List is empty\n");
						break;
					}
					System.out.print("\nEnter data to insert : ");
					data = s.nextInt();
					System.out.println("Enter data before which you want to insert " + data + " : ");
					element = s.nextInt();
					list.insertBefore(data, element);
					break;
				case 4:
					if(list.head == null) {
						System.out.println("\nError : List is empty\n");
						break;
					}
					System.out.print("\nEnter data to insert : ");
					data = s.nextInt();
					System.out.println("Enter data after which you want to insert " + data + " : ");
					element = s.nextInt();
					list.insertAfter(data, element);
					break;
				}
				break;
			case 2:
				if(list.head == null) {
					System.out.println("\nError : List is empty\n");
					break;
				}
				deletion();
				switch(s.nextInt()) {
				case 1:
					data = list.deleteFirst();
					System.out.println(data + " is deleted\n");
					break;
				case 2:
					data = list.deleteLast();
					System.out.println(data + " is deleted\n");
					break;	
				case 3:
					System.out.println("Enter data before which you want to delete : ");
					element = s.nextInt();
					data = list.deleteBefore(element);
					if(data == -1) {
						System.out.println("Couldn't delete the element before " + element + "\n");
						break;
					}
					System.out.println(data + " is deleted");
					break;
				case 4:
					System.out.println("Enter data after which you want to delete : ");
					element = s.nextInt();
					data = list.deleteAfter(element);
					if(data == -1) {
						System.out.println("Couldn't delete the element after " + element + "\n");
						break;
					}
					System.out.println(data + " is deleted");
					break;
				case 5:
					System.out.println("\nEnter item to delete : ");
					element =s.nextInt();
					data = list.deleteItem(element);
					if(data == -1) {
						System.out.println("Couldn't delete " + element + "\n");
						break;
					}
					System.out.println(data + " is deleted");
					break;
				}
				break;
			case 3:
				if(list.head == null)
					System.out.println("\nThe list is empty...\n");
				else
					list.print();
				break;
			case 0:
				quit = true;
				break;
			}
		}
		System.exit(0);
	}
}
