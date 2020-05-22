import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.management.Query;


public class ReverseStringUsingStackAsArray {

	int size;
	static int top=-1;
	public static void main(String[] args) {

		ReverseStringUsingStackAsArray array = new ReverseStringUsingStackAsArray();
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		char[] arr = new char[str.length()];
		array.size = str.length();
		for(int i=0;i<str.length();i++){
			array.push(str.charAt(i), arr);
		}
		String tempstr="";
		for(int i=0;i<str.length();i++){
			char temp = array.pop(arr);
			tempstr = tempstr.concat(String.valueOf(temp));
		}
		System.out.println("Reversed string is :: " + tempstr);
		
		Queue<Integer> queue = new LinkedList<Integer>();
	}

	private char pop(char[] arr) {
		if(top<0){
			System.out.println("Stack underflow");
			return 0;
		}
		char s = arr[top--];
		return s;
	}

	private boolean push(char ch, char[] arr) {
		if(top>=size){
			System.out.println("Stack Overflow");
			return false;
		}
		arr[++top]=ch;
		return true;
	}

}
