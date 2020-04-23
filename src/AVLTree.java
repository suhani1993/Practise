
public class AVLTree {

	private AVLNode root;
	public static void main(String[] args) {
		AVLTree avlTree = new AVLTree();
		avlTree.insert(30);
		avlTree.insert(10);
		
		System.out.print("Inorder traversal :: ");
		inorderTraversal(avlTree.root);
		System.out.println();
		
		avlTree.insert(20);
		
		System.out.print("Inorder traversal :: ");
		inorderTraversal(avlTree.root);
		System.out.println();
		
		avlTree.insert(23);
		System.out.println("root :: " + avlTree.root.value);
		System.out.print("Inorder traversal :: ");
		inorderTraversal(avlTree.root);
		System.out.println();
		
		avlTree.insert(22);
		System.out.println("root :: " + avlTree.root.value);
		System.out.print("Inorder traversal :: ");
		inorderTraversal(avlTree.root);
		System.out.println();
		
		avlTree.insert(21);
		System.out.println("root :: " + avlTree.root.value);
		System.out.print("Inorder traversal :: ");
		inorderTraversal(avlTree.root);
		System.out.println();
		
		avlTree.insert(32);
		System.out.println("root :: " + avlTree.root.value);
		System.out.print("Inorder traversal :: ");
		inorderTraversal(avlTree.root);
		System.out.println();
		
		avlTree.deleteNode(10);
		System.out.println("After delete.....");
		System.out.println("root :: " + avlTree.root.value);
		System.out.print("Inorder traversal :: ");
		inorderTraversal(avlTree.root);
		System.out.println();


		avlTree.deleteNode(22);
		System.out.println("After delete.....");
		System.out.println("root :: " + avlTree.root.value);
		System.out.print("Inorder traversal :: ");
		inorderTraversal(avlTree.root);
		System.out.println();

	}
	
	private void deleteNode(int value) {
		root = deleteRecursive(root, value);
	}

	private AVLNode deleteRecursive(AVLNode node, int value) {
		if(node == null){
			return null;
		}
		
		if(value < node.value){
			node.left = deleteRecursive(node.left, value);
		}else if(value > node.value){
			node.right = deleteRecursive(node.right, value);
		}else{
			if(node.left == null && node.right == null){
				node = null;
			}else if(node.left != null && node.right == null){
				node = node.left;
			}else if(node.left == null && node.right != null){
				node = node.right;
			}else{
				int findSmallestValue = findSmallestValue(node.right);
				node.value = findSmallestValue;
				node.right = deleteRecursive(node.right, findSmallestValue);
			}
		}
		if(node != null){
			node.height = Math.max(height(node.left), height(node.right)) + 1;
			
			// STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
			//  this node became unbalanced)
			int balance = getBalance(node);
			
			// If this node becomes unbalanced, then there are 4 cases
			
			// Left Left Case
			if (balance > 1 && getBalance(node.left) >= 0)
				return rightRotate(node);
			
			// Left Right Case
			if (balance > 1 && getBalance(node.left) < 0) {
				node.left =  leftRotate(node.left);
				return rightRotate(node);
			}
			
			// Right Right Case
			if (balance < -1 && getBalance(node.right) <= 0)
				return leftRotate(node);
			
			// Right Left Case
			if (balance < -1 && getBalance(node.right) > 0) {
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}
		}
		return node;
	}

	private int findSmallestValue(AVLNode node) {
		if(node.left != null){
			return findSmallestValue(node.left);
		}
		return node.value;
	}

	private static void inorderTraversal(AVLNode node) {
		if(node != null){
			inorderTraversal(node.left);
			System.out.print(" " + node.value);
			inorderTraversal(node.right);
		}
	}

	private void insert(int value) {
		root = insertNode(root, value);
	}

	private AVLNode insertNode(AVLNode node, int value) {
		if(node == null){
			return new AVLNode(value);
		}
		if(value < node.value){
			node.left = insertNode(node.left, value);
		}
		else if(value > node.value){
			node.right = insertNode(node.right, value);
		}
		else{
	        throw new RuntimeException("duplicate Key!");
	    }
		return rebalance(node, value);
	}

	private AVLNode rebalance(AVLNode node, int value) {
		int balanceFactor = getBalance(node);
		//LL case
		if(balanceFactor > 1 && value < node.left.value){
			return rightRotate(node);
		}
		
		//LR case
		if(balanceFactor > 1 && value > node.left.value){
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		
		//RL case
        if (balanceFactor < -1 && value < node.right.value)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        //RR Case
        if(balanceFactor < -1 && value > node.right.value){
        	return leftRotate(node);
        }
		return node;
	}

	private AVLNode leftRotate(AVLNode node) {
		AVLNode root = node.right;
		node.right = root.left;
		root.left = node;

		node.height = Math.max(height(node.left), height(node.right));
		root.height = Math.max(height(root.left), height(root.right));
		return root;
	}

	private AVLNode rightRotate(AVLNode node) {
		AVLNode tempRoot = node.left;
		node.left = tempRoot.right;
		tempRoot.right = node;
		
		node.height = Math.max(height(node.left), height(node.right));
		tempRoot.height = Math.max(height(tempRoot.left), height(tempRoot.right));
		return tempRoot;
	}

	private int getBalance(AVLNode node) {
		if(node == null){
			return 0;
		}
		return height(node.left) - height(node.right);
	}

	private int height(AVLNode node) {
		if(node == null){
			return -1;
		}
		return Math.max(height(node.left), height(node.right)) + 1;
	}

}

class AVLNode{
	int value;
	int height;
	AVLNode left;
	AVLNode right;
	
	AVLNode(int value){
		this.value = value;
		left = null;
		right = null;
	}
}
