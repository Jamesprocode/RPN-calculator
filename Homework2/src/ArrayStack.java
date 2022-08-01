
/*
 * ArrayStack uses the array-based implementation to implement
 * a Stack. 
 * 
 * Instance variables:
 * 		Double[] array: Keeps track of the whole stack in an array
 * 		int size: Keeps track of the number of elements in the Stack
 * Make both instance variables private
 * 
 * Constructor:
 * 		The constructor takes no parameter 
 * 		and initialize the array to length of 5
 *
 *	Methods:
 *		See comments above each methods to implement.
 *		
 */

import java.util.EmptyStackException;

public class ArrayStack{

	//instance variable
	Double[] array;
	int size;
	
	public ArrayStack() {
		// initialize our instance variables
		this.array = new Double[5];
		this.size = 0;
	}
	
	/*
	 * Returns true if the stack is empty.
	 * False otherwise.
	 */
	public boolean isEmpty() {
		
		if (this.size == 0) {
			return true;
		}
		return false;
	}
	
	/*
	 * Returns the number of elements in the stack.
	 */
	public int size() {
//		for (int i=0; i<this.array.length; i++) {
//			if (this.array[i] == null) {
//				return i;
//			}
//		}
		return this.size;
	}
	
	/*
	 * Takes a double d
	 * Push d to the top of the stack.
	 */
	public void push(double d) {
		if (this.array[this.array.length-1] != null) { // i do not have any more space
			Double[] newArray = new Double[this.array.length*2];
			for (int i = 0 ; i < this.array.length; i++) {
				newArray[i] = this.array[i];
			}
			
			this.array = newArray;
			this.array[this.size] = d;		
		}
		else { //still have space to insert
			for (int i = 0 ; i < this.array.length; i++) {
				
				if (this.array[i] == null) {
					this.array[i] = d;
					break;
				}
			}
		}
		this.size++;
		}
	
	
	/*
	 * Returns the top of the stack.
	 * Throws EmptyStackException if the stack is empty.
	 */
	public double peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return this.array[this.size-1];
		
	}
	
	/*
	 * Returns the top of the stack
	 * and removes the top from the stack.
	 * Throws EmptyStackException if the stack is empty.
	 */
	public double pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		Double top = this.array[this.size-1];
		this.array[this.size-1] = null;
//		for (int i = 0; i<this.size-1; i++) {
//				this.array[i] = this.array[i+1];
//				if (this.array[i] == null) {
//				this.array[i-1] = null;
//				}
		this.size--;
		return top;
	}
	
	
	/*
	 * Returns a String representation of the stack as follows:
	 * Top to Bottom: 5 -> 4 -> 3 -> 2 -> 1
	 */
	public String toString() {
		String list = "Top to Bottom: ";
		for (int i=this.size-1; i > 0; i--) {
			list = list + this.array[i] + " -> ";
		}
		list = list + this.array[0];
		return list;
	}
}
