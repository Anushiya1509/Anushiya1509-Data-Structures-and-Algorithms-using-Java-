package dataStructures;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
	
	private static Scanner s = new Scanner(System.in);
	
	public static char[] stack;
	public static int top;
	
	public static String infix;

	public static String postfix = "";
	
	public static boolean validateParanthesis(String str) {
		stack = new char[str.length()];
		top = 0;
		int i=0;
		while(i<str.length()) {
			if(str.charAt(i)=='{' || str.charAt(i)=='[' || str.charAt(i)=='(') {
				push(str.charAt(i));
				i++;
			}
			else if(str.charAt(i)=='}' || str.charAt(i)==']' || str.charAt(i)==')') {
				if((stack[top]=='{' && str.charAt(i)=='}') || (stack[top]=='[' && str.charAt(i)==']') || (stack[top]=='(' && str.charAt(i)==')')) {
					System.out.println(pop() + " is popped out of the stack.");
					i++;
				}
				else
					return false;
			}else i++;
		}
		if(top==0) {
			System.out.println("Parantheses are valid.");
			return true;
		}
		else {
			System.out.println("Parantheses are not valid.");
			return false;
		} 
	}
	
	public static void stackLength(int length) {
		stack = new char[length];
		top = 0;
		stack[top] = '(';
		System.out.println("Stack of length " + length +" is created.");
	}
	
	public static void push(char data) {
		stack[++top] = data;
		System.out.println(data + " is pushed into the stack.");
	}
	
	public static char pop() {
		return stack[top--];
	}
	
	public static void getInfixExpression() {
		System.out.println("Enter infix expression : ");
		infix = s.nextLine();
		if(validateParanthesis(infix))
			infix += ')';
		else {
			System.out.print("Parantheses are not valid. ");
			getInfixExpression();
		}
	}
	
	public static void getPostfixExpression() {
		System.out.println("Enter postfix expression : ");
		postfix = s.nextLine();
	}
	
	public static boolean isOperator(char data) {
		switch(data) {
		case '+' :
			while(stack[top]=='^' || stack[top]=='/' || stack[top]=='*' || stack[top]=='-' || stack[top]=='+') {
				postfix += pop();
			}
			push('+');
			return true;
		case '-' :
			while(stack[top]=='^' || stack[top]=='/' || stack[top]=='*' || stack[top]=='-' || stack[top]=='+') {
				postfix += pop();
			}
			push('-');
			return true;
		case '*' :
			while(stack[top]=='^' || stack[top]=='/' || stack[top]=='*') {
				postfix += pop();
			}
			push('*');
			return true;
		case '/' :
			while(stack[top]=='^' || stack[top]=='/' || stack[top]=='*') {
				postfix += pop();
			}
			push('/');
			return true;
		case '^' :
			push('^');
			return true;
		default :
			return false;
			
		}
	}
	
	public static void infixToPostfix() {
		for(int i=0; i<infix.length(); i++) {
			if(infix.charAt(i)=='(' || infix.charAt(i)=='[' || infix.charAt(i)=='{')
				push('(');
			else if(infix.charAt(i)==')' || infix.charAt(i)==']' || infix.charAt(i)=='}') {
				while(stack[top]!='(')
					postfix += pop();
				pop();
			}
			else if(!isOperator(infix.charAt(i)))
				postfix += infix.charAt(i);
		}
	}
	
	public static void postfixEvaluation(String postfix) {
		try {
			Stack<Integer> s = new Stack<Integer>();
			int x, y, temp=0;
			for(int i=0; i<postfix.length(); i++) {
				if(postfix.charAt(i)<='9' && postfix.charAt(i)>='0')
					s.push(postfix.charAt(i)-'0');
				else {
					x = s.pop();
					y = s.pop();
					switch(postfix.charAt(i)) {
					case '+':
						temp = x + y;
						break;
					case '-':
						temp = x - y;
						break;
					case '*':
						temp = x * y;
						break;
					case '/':
						temp = x / y;
						break;
					case '^':
						temp = (int)Math.pow(x, y);
						break;
					}
					s.push(temp);
				}
			}
			System.out.println();
		}catch(Exception e) {
			System.out.println("Expression cannot be evaluated.");
		}
	}

	public static void main(String[] args) {
		getInfixExpression();
		stackLength(10);
		infixToPostfix();
		System.out.println("Postfix Expression is " + postfix);
		postfixEvaluation(postfix);
	}

}                                       


















