package before.day15;

import util.Node;

public class PopulateNextRight {
	public static void main(String[] args) {
		PopulateNextRight populateNextRight=new PopulateNextRight();
		Node root=new Node(-1);
		root=root.getTestData();
		root=populateNextRight.connect(root);
		root.print(root);
	}

	public Node connect(Node root) {
		if (root == null||(root.right==null&&root.left==null)) {
			return root;
		}
		// 左右子树都不为空
		if (root.left != null && root.right != null) {
			root.left.next = root.right;
			root.right.next = getNextNoNullChild(root);
		} 
		if (root.left == null) {
			root.right.next = getNextNoNullChild(root);
		} 
		if (root.right == null) {
			root.left.next = getNextNoNullChild(root);
		}
		root.right = connect(root.right);
		root.left = connect(root.left);
		return root;

	}

	public Node getNextNoNullChild(Node root) {
		while (root.next != null) {
			if (root.next.left != null) {
				return root.next.left;
			}
			if (root.next.right != null) {
				return root.next.right;
			}
			root = root.next;
		}
		return null;
	}

}
