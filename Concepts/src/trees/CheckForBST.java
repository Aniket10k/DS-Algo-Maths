package trees;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class CheckForBST {
	// return true if the given tree is a BST, else return false
	boolean isBST(Node root) {
		return inOrder(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean inOrder(Node root, int min, int max) {
		if (root == null)
			return true;
		if (root.data <= min || root.data >= max) {
			return false;
		}
		boolean left = inOrder(root.left, min, root.data);
		if (!left)
			return false;
		boolean right = inOrder(root.right, root.data, max);
		if (!right)
			return false;
		return true;
	}
}
