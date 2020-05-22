import java.util.Arrays;


public class BinarySearchWithArray {

	public static void main(String[] args) {
		int[] arr = {9,48,3,93,100,54};
		Arrays.sort(arr);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
		int low=0;
		if(arr.length <= 0){
			System.out.println("Empty array found.");
			return;
		}
		int high = arr.length-1;
		int searchElement = 100;
		int position = binarySearch(arr, low, high, searchElement);
		if(position != -1){
			System.out.println("Position of searched element is " + position);
		}else{
			System.out.println("Searched element is not found");
		}
	}

	private static int binarySearch(int[] arr, int low, int high, int searchElement) {
		int mid = (low + high)/2;
		if(arr[mid] == searchElement){
			return mid;
		}
		else if(searchElement < arr[mid]){
			high = mid-1;
			return binarySearch(arr, low, high, searchElement);
		}
		else if(searchElement > arr[mid]){
			low=mid+1;
			return binarySearch(arr, low, high, searchElement);
		}
		return -1;
	}

}
