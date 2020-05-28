/*
 * This algorithm is used to sort array
 * It is based on divide and conquer method
 * It is implemented using recursion as we deal with the subproblems rather than main problem.
 * 
 * This algorithm can be described as the following 2 step process :
 * 1. Divide : We divide the input array into two halves. 
 *             The pivot being the midpoint of the array
 *             This step is carried out recursively until no more half arrays to divide
 *             
 * 2. Conquer : We sort and merge the divided arrays from bottom to top and get the sorted array.
 */
public class MergesortExample {

	public static void main(String[] args) {
		MergesortExample ms = new MergesortExample();
		int[] arr={10,6,8,5,7,3,4};
		ms.mergeSort(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
	}

	private void mergeSort(int[] arr, int length) {
		if(length < 2){
			return;
		}
		int mid = length/2;
		int[] leftArr = new int[mid];
		int[] rightArr = new int[length-mid];
		
		for (int i = 0; i < leftArr.length; i++) {
			leftArr[i] = arr[i];
		}
		
		for (int i = 0; i < rightArr.length; i++) {
			rightArr[i] = arr[mid+i];
		}
		
		mergeSort(leftArr, leftArr.length);
		mergeSort(rightArr, rightArr.length);
		
		merge(arr, leftArr, rightArr);
	}

	private void merge(int[] arr, int[] leftArr, int[] rightArr) {
		int i=0, j=0, k=0;
		while(i<leftArr.length && j<rightArr.length){
			if(leftArr[i] <= rightArr[j]){
				arr[k++] = leftArr[i++];
			}else{
				arr[k++] = rightArr[j++];
			}
		}
		while(i<leftArr.length){
			arr[k++] = leftArr[i++];
		}
		while(j<rightArr.length){
			arr[k++] = rightArr[j++];
		}
	}
}
