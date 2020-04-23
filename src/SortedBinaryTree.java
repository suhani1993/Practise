
public class SortedBinaryTree {

	public static void main(String[] args) {
		SortedBinaryTree binaryTree = new SortedBinaryTree();
		int[] arr = new int[]{3,4,5,6,7,9};
		TreeNode sortedArrayToBST = binaryTree.sortedArrayToBST(arr);
		System.out.println(sortedArrayToBST.value);
	}

	public TreeNode sortedArrayToBST(int[] arr) {
		if (arr.length == 0)
			return null;
 
		return sortedArrayToBST(arr, 0, arr.length - 1);
	}

	private TreeNode sortedArrayToBST(int[] arr, int start, int end) {
		if(start>end){
			return null;
		}
		int mid = (start+end)/2;
		System.out.println("mid :: " + mid);
		TreeNode root = new TreeNode(arr[mid]);
		System.out.println("root :: " + root.value);
		root.left = sortedArrayToBST(arr, start, mid-1);
		root.right = sortedArrayToBST(arr, mid+1, end);
		return root;
	}
}

class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int value){
		this.value = value;
	}
}
