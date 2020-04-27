
public class StackUsingArray {

	int[] arr = new int[10];
	int size = -1;
	public static void main(String[] args) {

		StackUsingArray array = new StackUsingArray();
		array.push(25);
		array.push(2);
		array.push(13);
		array.display();
		
		System.out.println("-------------------");
		array.pop();
		array.display();
		
		System.out.println("-------------------");
		array.peek();
		
		System.out.println("-------------------");
		array.pop();
		array.peek();
	}
	
	public void pop(){
		if(size == -1){
			System.out.println("Array is empty is no pop is allowed");
		}
		size--;
	}
	
	public void peek(){
		if(size == -1){
			System.out.println("Array is empty");
		}
		System.out.println("Top element :: " + arr[size]);
	}
	
	public void push(int value){
		arr[++size] = value;
	}
	
	public void display(){
		if(size == -1){
			System.out.println("Array is empty");
		}
		int tempSize = size;
		while(tempSize >= 0){
			System.out.println(arr[tempSize]);
			--tempSize;
		}
	}
}
