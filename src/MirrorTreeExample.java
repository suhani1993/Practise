
public class MirrorTreeExample {

	BinaryTreeNode root;
	public static void main(String[] args) {
		MirrorTreeExample mirrorTreeExample = new MirrorTreeExample();
		mirrorTreeExample.root = new BinaryTreeNode(9);
		mirrorTreeExample.root.left = new BinaryTreeNode(8);
		mirrorTreeExample.root.left.left = new BinaryTreeNode(6);
//		mirrorTreeExample.root.left.right = new BinaryTreeNode(1);
		
		MirrorTreeExample mirrorTreeExample2 = new MirrorTreeExample();
		mirrorTreeExample2.root = new BinaryTreeNode(9);
		mirrorTreeExample2.root.left = new BinaryTreeNode(8);
//		mirrorTreeExample2.root.right.left = new BinaryTreeNode(1);
//		mirrorTreeExample2.root.right.right = new BinaryTreeNode(1);
		
		boolean checkMirrorImage = checkMirrorImage(mirrorTreeExample.root, mirrorTreeExample2.root);
		System.out.println("Is mirror trees? " + checkMirrorImage);
		
		boolean checkIfBinarySearchTree = checkIfBinarySearchTree(mirrorTreeExample.root);
		System.out.println("Is tree binary search tree? " + checkIfBinarySearchTree);
		
		checkIfBinarySearchTree = checkIfBinarySearchTree(mirrorTreeExample2.root);
		System.out.println("Is tree binary search tree? " + checkIfBinarySearchTree);
		
	}

	private static boolean checkIfBinarySearchTree(BinaryTreeNode node) {

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

	private static boolean checkMirrorImage(BinaryTreeNode root1, BinaryTreeNode root2) {
		if(root1 == null && root2 == null){
			return true;
		}else{
			if(root1 == null || root2 == null){
				return false;
			}
			return ((root1.value == root2.value) && 
					checkMirrorImage(root1.left, root2.right) &&
					checkMirrorImage(root1.right, root2.left));
		}
	}

}


class BinaryTreeNode{
	int value;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(int value){
		this.value = value;
		left = null;
		right = null;
	}
}