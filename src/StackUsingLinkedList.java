
public class StackUsingLinkedList {
	
	class StackNode{
		int value;
		StackNode pointerToNext;
		
		public StackNode(int value) {
			this.value = value;
			pointerToNext = null;
		}
	}

	static StackNode root;
	public static void main(String[] args) {
		StackUsingLinkedList list = new StackUsingLinkedList();
		list.push(11);
		list.push(43);
		list.push(2);
		
		list.display();
		list.peek();
		
		System.out.println("-----------------");
		System.out.println("After pop");
		list.pop();
		list.display();
		
		list.peek();
		
		System.out.println("-----------------");
		System.out.println("After pop");
		list.pop();
		list.display();
		
		System.out.println("-----------------");
		System.out.println("After pop");
		list.pop();
		list.display();

		list.peek();
	}
	
	public void peek(){
		if(root == null){
			System.out.println("Stack is empty so no top element is found");
			return;
		}

		System.out.println("Top element :: " + root.value);
	}
	
	public void push(int value){
		if(root == null){
			root = new StackNode(value);
		}else{
			StackNode node = new StackNode(value);
			node.pointerToNext = root;
			root = node;
		}
	}
	
	public void pop(){
		if(root == null){
			System.out.println("Stack underflow");
			return;
		}
		root = root.pointerToNext;
	}
	
	public void display(){
		if(root == null){
			System.out.println("Stack is empty");
			return;
		}
		StackNode node = root;
		while(node != null){
			System.out.println(node.value);
			node = node.pointerToNext;
		}
	}
}




