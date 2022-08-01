
/*
 * Do not modify this class.
 * This class represents general LinkedNodes that are used to build the Stack.
 * Each LinkedNode contains a reference to the next LinkedNode.
 * @author celiachen
 *
 */
public class LinkedNode {


	public LinkedNode next;
	
	/**
	 * Construct an empty LinkedNode.
	 */
	public LinkedNode() {
		
	}
	// （NumberNode)
	public void setNext(LinkedNode next) {
		this.next = next;
	}
	
	public LinkedNode getNext() {
		return this.next;
	}
	
}
