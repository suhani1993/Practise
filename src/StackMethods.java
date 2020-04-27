import java.util.ListIterator;
import java.util.Stack;


public class StackMethods {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(12);
		stack.push(25);
		stack.push(556);
		
		System.out.println(stack.empty());
		System.out.println(stack.peek());
		
//		System.out.println(stack.pop());
		
		System.out.println(stack.search(556));
		System.out.println(stack.search(12));
		
		stack.addElement(58);
		
		System.out.println(stack.search(12));
		
		stack.add(14);
		
		stack.add(2, 98);
		
		System.out.println("--------------------------------");
		ListIterator<Integer> elements = stack.listIterator();
		while(elements.hasNext()){
			Integer nextElement = elements.next();
			System.out.println(nextElement);
		}
	}

}
