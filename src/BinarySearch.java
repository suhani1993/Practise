import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class BinarySearch {

	public static void main(String[] args) {
		
		System.out.println("Please enter size of array :: ");
		Scanner scanner = new Scanner(System.in);
		int sizeOfArray = scanner.nextInt();
		System.out.println("Please enter numbers to create list :: ");
		List inputList = new ArrayList<Integer>();
		for(int i=0;i<sizeOfArray;i++){
			if(inputList.size() == sizeOfArray){
				break;
			}
			inputList.add(scanner.nextInt());
		}
		
		Collections.sort(inputList);
		System.out.println("Sorted list :: " + inputList);

		System.out.println("Please enter key to find :: ");
		int key = scanner.nextInt();
		
		BinarySearchKey(key, inputList, 0, inputList.size()-1);

	}

	private static int BinarySearchKey(int key, List inputList, int min, int max) {
		int midPoint = findMidPoint(max, inputList);
		int indexOfMid = inputList.indexOf(midPoint) + 1;
		List innerList = new ArrayList<Integer>();
		if(key > midPoint){
			for(int i=indexOfMid;i<=max;i++){
				innerList.add(inputList.get(i));
			}
			System.out.println("inner list :: " + innerList);
			max = innerList.size();
			return findMidPoint(max, innerList);
		}else if(key < midPoint){
			innerList.clear();
			for(int i=0;i<indexOfMid;i++){
				innerList.add(inputList.get(i));
			}
			max = innerList.size();
			return findMidPoint(max, innerList);
		}else{
			System.out.println("return key ::  " + key);
			return key;
		}
	}

	private static int findMidPoint(int max, List inputList) {
		int mid;
		if(max % 2 == 0){
			mid = max/2;
		}else{
			mid = (max+1)/2;
		}
		System.out.println("mid :: " + mid);
		System.out.println("middle term :: " + (int)inputList.get(mid-1));
		return (int)inputList.get(mid-1);
	}

}
