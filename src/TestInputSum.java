import java.util.Scanner;


public class TestInputSum {

	public static void main(String[] args) {
		
		sumOfNumbers(5);
		
	}

	private static void sumOfNumbers(int no) {
		Scanner scanner = new Scanner(System.in);
		double sum = 0;
		System.out.println("Enter 5 numbers :: ");
		for(int i=0;i<no;i++){
			double nextNum = scanner.nextDouble();
			sum += nextNum;
		}
		System.out.println("The sum is :: " + sum);
	}
}
