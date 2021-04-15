package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;

/*class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}*/

public class DeletionInCompleteBinaryTree {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String arr[] = br.readLine().split(" ");
			int key = Integer.parseInt(arr[0]);
			String s = br.readLine();
			Node root = buildTree(s);

			Solution g = new Solution();
			g.deletionBT(root, key);
			printInorder(root);
			System.out.println();
			t--;

		}
	}
}

//} Driver Code Ends

/*
 * Node class is as follows:
 * 
 * class Node { int data; Node left, right;
 * 
 * public Node(int data){ this.data = data; } }
 */
class Solution {

	public Node deletionBT(Node root, int key) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return root;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node temp = null;
		Node keyNode = null;
		while (!queue.isEmpty()) {
			temp = queue.remove();
			if (temp.data == key) {
				keyNode = temp;
			}
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
		keyNode.data = temp.data;
		Queue<Node> queue1 = new LinkedList<>();
		queue1.add(root);
		while (!queue1.isEmpty()) {
			Node curr = queue1.remove();
			if (curr == temp) {
				curr = null;
				return root;
			}
			if (curr.right != null) {
				if (curr.right == temp) {
					curr.right = null;
					return root;
				} else {
					queue1.add(curr.right);
				}
			}
			if (curr.left != null) {
				if (curr.left == temp) {
					curr.left = null;
					return root;
				} else {
					queue1.add(curr.left);
				}
			}
		}
		return root;
	}
}