
public class CheckBinarySearchTree {
	
	private static Node root;
	class Node{
		int value;
		Node left;
		Node right;
		
		Node(int value){
			this.value = value;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		CheckBinarySearchTree binaryTree = new CheckBinarySearchTree();
		root = binaryTree.insert(10);
		root.right = binaryTree.insert(11);
		root.left = binaryTree.insert(9);
		root.right.right = binaryTree.insert(12);
		root.right.right.right = binaryTree.insert(13);
		root.left.left = binaryTree.insert(8);
		
		boolean isBinaryTree = checkIfBinarySearchTree(root);
		if(isBinaryTree){
			System.out.println("Tree is binary search tree");
		}else{
			System.out.println("Tree is not binary search tree");
		}
	}
	
	private static boolean checkIfBinarySearchTree(Node root) {
		if(root.left == null && root.right == null){
			return true;
		}
		if(root.left != null && root.right == null){
			return checkIfBinarySearchTree(root.left);
		}
		if(root.right != null && root.left == null){
			return checkIfBinarySearchTree(root.right);
		}else if(root.left != null && root.left.value < root.value && root.right != null && 
				root.right.value > root.value){
			if(checkIfBinarySearchTree(root.left) && checkIfBinarySearchTree(root.right)){
				return true;
			}
		}
		return false;
	}

	public Node insert(int value){
		return new Node(value);
	}
	
}
