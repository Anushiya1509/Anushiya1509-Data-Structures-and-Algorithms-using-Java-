package dataStructures;

import java.util.Stack;

public class BST {
	
	Node root;
	
	Node loc, par;
	
	public class Node {
		int info;
		Node left, right;
		
		public Node(int info) {
			this.info = info;
			this.left = null;
			this.right = null;
		}
	}
	
	public void find(int data) {
		if(root == null) {
			loc = null;
			par = null;
			return;
		}
		if(root.info == data) {
			loc = root;
			par = null;
			return;
		}
		Node ptr=null, pptr=root;
		if(data < root.info)
			ptr = root.left;
		if(data > root.info) 
			ptr = root.right;
		while(ptr!=null) {
			if(ptr.info == data) {
				loc = ptr;
				par = pptr;
				return;
			}
			else if(data < ptr.info) {
				pptr = ptr;
				ptr = ptr.left;
			}
			else if(data > ptr.info) {
				pptr = ptr;
				ptr = ptr.right;
			}
		}
		loc = ptr;
		par = pptr;
	}
	
	public void insert(int data) {
		find(data);
		if(loc!=null) {
			System.out.println(data + " is already present in the tree.\nDuplication is not allowed.");
			return;
		}
		Node node = new Node(data);
		if(par==null) 
			root = node;
		else if(data < par.info)
			par.left = node;
		else
			par.right = node;
		System.out.println(data + " is inserted in the BST.");
	}
	
	private void deleteA(Node loc, Node par) {
		Node child;
		if(loc.left==null && loc.right==null)
			child = null;
		else if(loc.left!=null)
			child = loc.left;
		else 
			child = loc.right;
		if(par==null)
			root = child;
		else if(loc==par.left)
			par.left = child;
		else if(loc==par.right)
			par.right = child;
	}
	
	private void deleteB(Node loc, Node par) {
		Node suc=loc.right, parsuc=loc;
		while(suc.left!=null){
			parsuc = suc;
			suc = suc.left;
		}
		deleteA(suc, parsuc);
		if(par==null)
			root = suc;
		else if(par.left==loc)
			par.left = suc;
		else if(par.right==loc)
			par.right = suc;
		suc.left = loc.left;
		suc.right = loc.right;
		
	}
	
	public void delete(int data) {
		find(data);
		if(loc==null) {
			System.out.println(data + " is not found in the tree.");
			return;
		}
		if(loc.left!=null && loc.right!=null)
			deleteB(loc, par);
		else
			deleteA(loc, par);
		System.out.println(data + " is deleted from the tree.");
	}
	
	public void preorder(Node ptr) {
		if(ptr==null) 
			return;
		System.out.print(ptr.info + " ");
		preorder(ptr.left);
		preorder(ptr.right);
	}
	
	public void nonRecursivePreorder(Node ptr) {
		if(ptr==null)
			return;
		Stack<Node> stack = new Stack<Node>();
		stack.push(ptr);
		while(!stack.empty()) {
			Node node = stack.pop();
			System.out.print(node.info + " ");
			if(node.right!=null)
				stack.push(node.right);
			if(node.left!=null)
				stack.push(node.left);
		}
	}

	public void inorder(Node ptr) {
		if(ptr==null)
			return;
		inorder(ptr.left);
		System.out.print(ptr.info + " ");
		inorder(ptr.right);
	}
	
	public void nonRecursiveInorder(Node ptr) {
		if(ptr==null)
			return;
		Stack<Node> stack = new Stack<Node>();
		while(ptr!=null || stack.size()>0) {
			while(ptr!=null) {
				stack.push(ptr);
				ptr = ptr.left;
			}
			ptr = stack.pop();
			System.out.print(ptr.info + " ");
			ptr = ptr.right;
		}
	}
	
	public void postorder(Node ptr) {
		if(ptr==null)
			return;
		postorder(ptr.left);
		postorder(ptr.right);
		System.out.print(ptr.info + " ");
	}

    public void nonRecursivePostorder(Node root) {
    	Node ptr = root;
    	Stack<Node> stack = new Stack<Node>();
    	while(!stack.isEmpty() || ptr!=null) {
    		if(ptr!=null) {
    			stack.push(ptr);
    			System.out.println(ptr.info + " is pushed into stack");
    			ptr = ptr.left;
    		}else {
    			Node temp = stack.peek().right;
    			if(temp==null) {
    				temp = stack.pop();
    				System.out.print(temp.info + " ");
    				while(!stack.isEmpty() && temp==stack.peek().right) {
        				temp = stack.pop();
        				System.out.print(temp.info + " ");
        			}
    			}else {
    				ptr = temp;
    			}
    		}
    	}
    }


	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(80);
		bst.insert(60);
		bst.insert(90);
		bst.insert(55);
		bst.insert(65);
		bst.insert(58);
		bst.insert(62);
		bst.insert(85);
		bst.insert(95);
		bst.insert(92);
		bst.insert(100);
		bst.insert(93);
		System.out.print("Preorder traversal : ");
		bst.preorder(bst.root);
		System.out.println();
		System.out.print("Inorder traversal : ");
		bst.inorder(bst.root);
		System.out.println();
		System.out.print("Postorder traversal : ");
		bst.postorder(bst.root);
		System.out.println();
		bst.insert(60);
		bst.delete(100);
		System.out.print("Preorder traversal : ");
		bst.preorder(bst.root);
		System.out.println();
		System.out.print("Inorder traversal : ");
		bst.inorder(bst.root);
		System.out.println();
		System.out.print("Postorder traversal : ");
		bst.postorder(bst.root);
		System.out.println();
		System.out.print("Non-Recursive Preorder traversal : ");
		bst.nonRecursivePreorder(bst.root);
		System.out.println();
		System.out.print("Non-Recursive Inorder traversal : ");
		bst.nonRecursiveInorder(bst.root);
		System.out.println();
		System.out.print("Non-Recursive Postorder traversal : ");
		bst.nonRecursivePostorder(bst.root);
		System.out.println();
	}

}
