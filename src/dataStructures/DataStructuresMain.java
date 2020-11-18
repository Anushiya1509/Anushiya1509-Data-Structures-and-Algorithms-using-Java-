package dataStructures;

public class DataStructuresMain {

	public static void main(String[] args) {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		System.out.println(stack.isEmpty());
		stack.pop();
		stack.print();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.print();
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		stack.push(11);
		stack.pop();
		stack.print();
	}

}
