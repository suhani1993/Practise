import java.util.Scanner;
import java.util.Stack;


public class ReverseStringUsingStack {

	public static void main(String[] args) {

		System.out.print("Enter String :: ");
		Scanner scanner = new Scanner(System.in);
//		char[] arr = str.toCharArray();
//		popStringUsingStack(arr);
		String str = scanner.nextLine();
		
		if(!str.isEmpty()){
			Stack<Character> stack = new Stack<Character>();
			for(int i=0;i<str.length();i++){
				stack.push(str.charAt(i));
			}
			
			String reverseStr = "";
			while(!stack.empty()){
				reverseStr = reverseStr.concat(String.valueOf(stack.pop()));
			}
			System.out.println("Reversed String is :: " + reverseStr);
		}
	}

}
