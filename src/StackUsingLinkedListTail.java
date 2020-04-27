import java.util.Stack;

public class StackUsingLinkedListTail {

	class Node{
		int value;
		Node next;
		Node prev;
		
		Node(int value){
			this.value = value;
			next = null;
			prev = null;
		}
	}
	
	Node root;
	public static void main(String[] args) {
		StackUsingLinkedListTail linkedListTail = new StackUsingLinkedListTail();
		linkedListTail.push(14);
		linkedListTail.push(25);
		linkedListTail.push(3);
		
		linkedListTail.display();
		
		System.out.println("------------------------");
		linkedListTail.pop();
		linkedListTail.display();
		
	}
	
	public void pop(){
		if(root == null){
			System.out.println("Stack is empty");
		}
		root = root.prev;
	}
	
	public void display(){
		if(root == null){
			System.out.println("Stack is empty");
			return;
		}
		Node tempNode = root;
		while(tempNode != null){
			System.out.println(tempNode.value);
			tempNode = tempNode.prev;
		}
	}
	
	public void push(int value){
		if(root == null){
			root = new Node(value);
		}else{
			Node node = new Node(value);
			root.next = node;
			node.prev = root;
			root = node;
		}
	}

}
