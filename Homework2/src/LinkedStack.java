
/*
 * LinkedStack uses the linked-based implementation to implement
 * a Stack. 
 * 
 * Instance variables:
 * 		LinkedNode top: Keeps track of the top of the Stack
 * 		int size: Keeps track of the number of elements in the Stack
 * Make both instance variables private
 *
 * Methods:
 *		See comments above each methods to implement.
 *
 */

import java.util.EmptyStackException;

public class LinkedStack{
	
	//instance variables
	private LinkedNode top;
	private int size;
	/*
	 * Returns true if the stack is empty.
	 * False otherwise.
	 */
	public boolean isEmpty() {
		if (this.top == null) {
			return true;
		}
		return false;
	}
	
	/*
	 * Returns the number of elements in the stack.
	 */
	public int size() {
//		LinkedNode current = this.top;
//		int count = 0;
//		while (current != null) {
//			count++;
//			current = current.next; 
//		}
		return this.size;
	}
	
	/*
	 * Takes a LinkedNode n
	 * Push n to the top of the stack.
	 */
	public void push(LinkedNode n) {
		if (isEmpty()) {
			this.top = n;
		}

		else {
			LinkedNode current = this.top;
			n.next = current;
			this.top = n;
//			System.out.println("");
			

		}
		this.size++;
	}
	
	/*
	 * Returns the top of the stack.
	 * Throws EmptyStackException if the stack is empty.
	 */
	public LinkedNode peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else {
		return this.top;
		}
	}
	
	/*
	 * Returns the top of the stack
	 * and removes the top from the stack.
	 * Throws EmptyStackException if the stack is empty.
	 */
	public LinkedNode pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			LinkedNode current = this.top;
			this.top = current.next;
			this.size--;
			return current;
		}
	}
	
	/*
	 * Returns a String representation of the stack as follows:
	 * Top to Bottom: 5 -> 4 -> 3 -> 2 -> 1
	 */
	public String toString() {
		String list = "Top to Bottom: ";
		LinkedNode current = this.top;
		for (int i =0; i < this.size()-1; i++) {
			if (current instanceof NumberNode) {
				NumberNode currentNum = (NumberNode)current;
				list = list + currentNum.value + " -> ";
			}
			if (current instanceof OperatorNode) {
				OperatorNode currentOp = (OperatorNode)current;

				list = list + currentOp.operator + " -> ";
			}
//			
			
			current = current.next;
		}
		if (current instanceof NumberNode) {
			NumberNode currentNum = (NumberNode)current;
			list = list + currentNum.value;
		}
		if (current instanceof OperatorNode) {
			OperatorNode currentOp = (OperatorNode)current;

			list = list + currentOp.operator;
		}
//		
		return list;
	}
}
