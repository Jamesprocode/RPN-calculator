
public class StackTester {
	public static void main(String[] args) {
		//arraystack test cases
//		ArrayStack astack = new ArrayStack();
//		System.out.println(astack.isEmpty()); //true
//		System.out.println(astack.size());//0
//		astack.push(0);
//		astack.push(1);
//		astack.push(2);
//		astack.push(3);
//		astack.push(4);
//		astack.push(5);
//		astack.push(6);
//		System.out.println(astack);
//		System.out.println(astack.isEmpty()); //false
//		System.out.println(astack.size()); //4
//		System.out.println(astack.peek());//3.0
//		System.out.println(astack.pop());
//		System.out.println(astack);
		
		//linkedstack test cases
		LinkedStack lstack = new LinkedStack();
		System.out.println(lstack.isEmpty()); //true
		System.out.println(lstack.size());//0
		System.out.println(lstack);
		NumberNode a = new NumberNode(0);
		NumberNode b = new NumberNode(1);
		NumberNode c = new NumberNode(2);
		OperatorNode d = new OperatorNode("%");
		lstack.push(a);
		lstack.push(b);
		lstack.push(c);
		lstack.push(d);
		
		System.out.println(lstack);
		System.out.println(lstack.isEmpty()); //false
		System.out.println(lstack.size()); //3
		LinkedNode peek = new LinkedNode();
		peek = lstack.peek();
		if (peek instanceof NumberNode) {
			NumberNode peekNum = (NumberNode)peek;
			System.out.println(peekNum.value);//2.0

		}
		if (peek instanceof OperatorNode) {
			OperatorNode peekOp = (OperatorNode)peek;
			System.out.println(peekOp.operator);//2.0

		}
		LinkedNode pop = new LinkedNode();
		pop = lstack.pop();
		if (peek instanceof NumberNode) {
			NumberNode popNum = (NumberNode)pop;
			System.out.println(popNum.value);//2.0

		}
		if (peek instanceof OperatorNode) {
			OperatorNode popOp = (OperatorNode)pop;
			System.out.println(popOp.operator);//2.0

		}
		System.out.println(lstack);
	}
}
