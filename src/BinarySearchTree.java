import java.util.ArrayList;


public class BinarySearchTree {
	
	Node root;
	public static void main(String[] args) {
		BinarySearchTree binaryTree = new BinarySearchTree();
		binaryTree.add(9);
		binaryTree.add(6);
		binaryTree.add(4);
		binaryTree.add(5);
		binaryTree.add(3);
		binaryTree.add(8);
		binaryTree.add(7);
		binaryTree.add(10);
		binaryTree.add(12);
		binaryTree.add(15);
		binaryTree.printLeafNodes(binaryTree.root);
		System.out.println();

//		binaryTree.delete(4);
		
		boolean isBalanced = isBalanced(binaryTree.root);
		System.out.println("isBalanced :: "  + isBalanced);
		
		binaryTree.printLeafNodes(binaryTree.root);
		System.out.println();
		boolean containsNodeRecursive = binaryTree.containsNodeRecursive(binaryTree.root, 5);
		System.out.println(containsNodeRecursive);

		System.out.println("inorder traversal :: ");
		inorderTraversal(binaryTree.root);
		System.out.println();
		System.out.println("preorder traversal :: ");
		preorderTraversal(binaryTree.root);
		System.out.println();
		System.out.println("postorder traversal :: ");
		postorderTraversal(binaryTree.root);
		System.out.println();
		
		int height = getHeight(binaryTree.root)-1;
		System.out.println("height :: " + height);
		
		int size = size(binaryTree.root);
		System.out.println("size :: " + size);
		
		binaryTree.pathBetweenNodes(5, binaryTree.root);
		binaryTree.pathBetweenNodes(15, binaryTree.root);
		System.out.println("Steps :: " + binaryTree.step);
		System.out.println("Visited nodes :: " + visitedNodes);
		
		boolean checkIfBinarySearchTree = checkIfBinarySearchTree(binaryTree.root);
		System.out.println("Is Tree Binary Search Tree? " + checkIfBinarySearchTree);
		
		System.out.println("Maximum height :: " + binaryTree.maxHeight(binaryTree.root.left));
		
		System.out.println("Maximum depth :: " + binaryTree.maxDepth(binaryTree.root, 7));
		
		int mirrorOfNode = binaryTree.findMirrorOfNode(4, binaryTree.root.left, binaryTree.root.right);
		System.out.println("mirrorOfNode :: " + mirrorOfNode);
		
	}
	
	private int findMirrorOfNode(int value, Node left, Node right){
		if(left == null || right == null){
			return 0;
		}
		
		if(value == left.value){
			return right.value;
		}
		if(value == right.value){
			return left.value;
		}
		return findMirrorOfNode(value, left.left, right.right);
	}
	
	private int maxDepth(Node node, int value) {
		if(node != null){
			if(value < node.value){
				return maxDepth(node.left, value) + 1;
			}else if(value > node.value){
				return maxDepth(node.right, value) + 1;
			}
		}
		return 0;
	}

	public int maxHeight(Node node){
		if(node == null){
			return 0;
		}
		int left = maxHeight(node.left);
		int right = maxHeight(node.right);
		return Math.max(left, right) + 1;
	}
	
	private static boolean checkIfBinarySearchTree(Node node) {

		if(node == null){
			return true;
		}
		
		if(node.left != null && (node.left.value > node.value)){
			return false;
		}
		
		if(node.right != null && node.right.value < node.value){
			return false;
		}
		
		if(checkIfBinarySearchTree(node.left) && checkIfBinarySearchTree(node.right)){
			return true;
		}else{
			return false;
		}
	}
	
	private static boolean isBalanced(Node node) {
	      if(node == null) {
	          return true;
	      }
	      return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1 
	              && isBalanced(node.left) 
	              && isBalanced(node.right);
	  }

	int step;
	static ArrayList<Integer> visitedNodes = new ArrayList<Integer>();
	public void pathBetweenNodes(int value, Node node){
		if(node != null){
			if(!visitedNodes.contains(node.value)){
				visitedNodes.add(node.value);
			}
			if(value < node.value){
				step++;
				pathBetweenNodes(value, node.left);
			}else if(value > node.value){
				step++;
				pathBetweenNodes(value, node.right);
			}
		}
	}
	
	private static int getHeight(Node node) {
		if(node != null){
			int leftHeight = 0; int rightHeight = 0;
			if(node.left != null){
				leftHeight = getHeight(node.left);
			}
			
			if(node.right != null){
				rightHeight = getHeight(node.right);
			}
			int diff = leftHeight-rightHeight;
			if(Math.abs(diff)>1){
				return -1;
			}
			return 1 + Math.max(leftHeight, rightHeight);
		}
		return 0;
	}
	
	public static int size(Node node){
		if (node == null) 
            return 0; 
        else
            return(size(node.left) + 1 + size(node.right)); 
	}
	
	private static void postorderTraversal(Node node) {
		if(node != null){
			postorderTraversal(node.left);
			postorderTraversal(node.right);
			System.out.print(" " + node.value);
		}
	}

	private static void preorderTraversal(Node node) {
		if(node != null){
			System.out.print(" " + node.value);
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}
	}

	private static void inorderTraversal(Node node) {
		if(node != null){
			inorderTraversal(node.left);
			System.out.print(" " + node.value);
			inorderTraversal(node.right);
		}
	}

	public void delete(int value) {
	    root = deleteRecursive(root, value);
	}
	
	private Node deleteRecursive(Node current, int value) {
	    if (current == null) {
	        return null;
	    }
	 
	    if (value == current.value) {
	    	//no leaf nodes of current node
	    	if (current.left == null && current.right == null) {
	    	    return null;
	    	}
	    	//only left leaf node of current node
	    	else if (current.right == null && current.left != null) {
	    	    return current.left;
	    	}
	    	//only right leaf node of current node
	    	else if(current.left == null && current.right != null){
	    	    return current.right;
	    	}
	    	//both leaf nodes present
	    	else{
	    		int smallestValue = findSmallestValue(current.right);
	    		current.value = smallestValue;
	    		current.right = deleteRecursive(current.right, smallestValue);
	    		return current;
	    	}
	    }else if (value < current.value) {
	        current.left = deleteRecursive(current.left, value);
	    }else{
	    	current.right = deleteRecursive(current.right, value);
	    }
	    return current;
	}
	
	private int findSmallestValue(Node root) {
	    return root.left == null ? root.value : findSmallestValue(root.left);
	}
	
	public void printLeafNodes(Node node) {
	    // base case
	    if (node == null) {
	      return;
	    }

	    if (node.left == null && node.right == null) {
	      System.out.print(node.value);
	    }

	    printLeafNodes(node.left);
	    printLeafNodes(node.right);
	  }
	
	private boolean containsNodeRecursive(Node current, int value) {
	    if (current == null) {
	        return false;
	    } 
	    if (value == current.value) {
	        return true;
	    } 
	    return value < current.value
	      ? containsNodeRecursive(current.left, value)
	      : containsNodeRecursive(current.right, value);
	}
	
	private void add(int value) {
		root = addRecursive(root, value);
	}

	private Node addRecursive(Node current, int value) {
		if(current == null){
			return new Node(value);
		}
		if(value < current.value){
			current.left = addRecursive(current.left, value);
		}else if(value > current.value){
			current.right = addRecursive(current.right, value);
		}
		return current;
	}
}

class Node {
	int value;
	Node left;
	Node right;
	
	Node(int value){
		this.value = value;
		right = null;
		left = null;
	}
}
