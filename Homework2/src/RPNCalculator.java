import java.io.File;
import java.lang.Math;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RPNCalculator {
	
	
	/*
	 * takes a string and check if it is a Double type
	 * @parem String sting
	 * @return true if it is a Double type false if it is not
	 */
	public static boolean isDouble(String string) {    
	    try {
	        Double num = Double.parseDouble(string);
	        return true;
	    } catch (NumberFormatException e) {
	    	return false;
	    }
	    
	}
	/*
	 * takes a string and check if it is a operator
	 * @parem String sting
	 * @return true if it is a operator false if it is not
	 */
	public static boolean isOperator(String string) {
		String[] operator = {"+", "-", "*", "/", "^", "%"};
		for (int i=0; i<operator.length; i++) {
		if (operator[i].equals(string)) {
			return true;
		}		
	}
		return false;
	}
	/*
	 * takes a file and put all element into a stack
	 * @parem file
	 * @return linkedStack
	 */
	public static LinkedStack pushToStack(File file) throws FileNotFoundException {
		LinkedStack PRN = new LinkedStack();
		Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String a = scan.nextLine();
				if(isDouble(a)) {
					Double num = Double.parseDouble(a);
					NumberNode Num = new NumberNode(num);
					PRN.push(Num);
				}
				else if(isOperator(a)) {		
					OperatorNode op = new OperatorNode(a);
					PRN.push(op);
				}
				else {
					throw new NumberFormatException();
				}

			}
		return PRN;
	}
		
	
	/*
	 * takes two numbers and an operand and return the calculation
	 * @parem NumberNode a, NumberNode b, OperatorNode a
	 * @return Double
	 */
	public static Double calculation(NumberNode a, NumberNode b, OperatorNode x) {
		if (x.operator.equals("+")) {
			return a.value + b.value;
		}
		else if (x.operator.equals("-")) {
			return a.value - b.value;
		}
		else if (x.operator.equals("*")) {
			return a.value * b.value;
		}
		else if (x.operator.equals("/")) {
			Double c = b.value;
			if (c.equals(0.0)) {
				throw new ArithmeticException();
			}
			return a.value / b.value;
		}
		else if (x.operator.equals("^")) {
			return Math.pow(a.value, b.value);
		}
		else if (x.operator.equals("%")) {
			return a.value % b.value;
		}
		return null;
		
	}
	
	/*
	 * pop first two numbers and put them into a double list
	 * @parem LinkedStack linkedstack
	 * @return Double[]
	 */
	public static Double evaluate(LinkedStack linkedstack) {
		//new stack
		
		LinkedStack PRNhelper = new LinkedStack();

		// get numbers and save in stack
		while (!linkedstack.isEmpty()) {
			while (linkedstack.peek() instanceof NumberNode) {
				PRNhelper.push(linkedstack.pop());
//				System.out.println(PRNhelper);
			}
		
			//if (PRN.peek() instanceof OperatorNode) {
			OperatorNode Op = (OperatorNode) linkedstack.pop();
			//String op = Op.operator;		
		
			NumberNode num1 = (NumberNode)PRNhelper.pop();
			NumberNode num2 = (NumberNode)PRNhelper.pop();

			LinkedNode calculated = new NumberNode(calculation(num2, num1, Op));
			PRNhelper.push(calculated);
		}
		NumberNode result = (NumberNode)PRNhelper.pop();
		return result.value;		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length != 1) {
			System.out.println("not a valid input");
			System.exit(0);
		}
		//get the file
		File file = new File(args[1]);
		//put the file in to stack
		LinkedStack PRN = new LinkedStack();
		try {
		PRN = pushToStack(file);
		}
		catch (NumberFormatException e){
			System.out.println("not a valid input");
			System.exit(0);
		}
		if (PRN.peek() instanceof OperatorNode) {
			System.out.println("not a valid input");
			System.exit(0);
		}
		System.out.println(PRN);
		

		try {
		System.out.println("result: " + evaluate(PRN));
		}
		catch(ArithmeticException e){
		System.out.println("cannot divide by 0");
		}


		
		
		
	}
}		


