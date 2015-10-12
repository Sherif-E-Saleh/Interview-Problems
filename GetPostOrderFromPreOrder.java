package questions;

import java.util.ArrayList;
import java.util.Arrays;

public class GetPostOrderFromPreOrder {

	/*
	 * Get the postorder Traversal of a binary search tree from the preorder
	 */

	public static ArrayList<Integer> postOrder = new ArrayList<Integer>();

	public static TreeNode insert(int[] preOrder) {
		TreeNode root = new TreeNode(preOrder[0]);
		TreeNode node;
		for (int i = 1; i < preOrder.length; i++) {
			node = new TreeNode(preOrder[i]);
			insertActually(root, node);
		}
		return root;
	}

	public static void insertActually(TreeNode root, TreeNode node) {
		if (node.val < root.val) {
			if (root.left == null)
				root.left = node;
			else
				insertActually(root.left, node);
		} else {
			if (root.right == null)
				root.right = node;
			else
				insertActually(root.right, node);
		}
	}

	public static void postOrderTraverse(TreeNode root) {
		if (root == null)
			return;
		else {
			postOrderTraverse(root.left);
			postOrderTraverse(root.right);
			postOrder.add(root.val);
		}
	}

	public static Object[] postOrder(int[] preOrder) {
		postOrderTraverse(insert(preOrder));
		return postOrder.toArray();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input = { 9, 2, 1, 4, 3, 5, 10, 11, 12 };
		System.out.println(Arrays.deepToString(postOrder(input)));

	}

}
