package util;

public class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node(int val) {
		this.val = val;
	}

	public void print(Node root) {
		if (root == null) {
			return;
		}
		print(root.left);
		System.out.print(root.val + " ");
		print(root.right);
	}

	public Node getTestData() {
		/**
		 * 测试数据
		 * 
		 * ************ 5
		 * 
		 * ********** / ** \
		 * 
		 * ******** 1 ****** 6
		 * 
		 * ****** / ** \ ***** \
		 * 
		 * *****1 ****** 3 ***** 6
		 */
		Node root = new Node(5);
		Node[] nodes = new Node[5];
		nodes[0] = new Node(1);
		nodes[1] = new Node(6);
		nodes[2] = new Node(1);
		nodes[3] = new Node(3);
		nodes[4] = new Node(6);
		root.left = nodes[0];
		root.right = nodes[1];
		nodes[0].left = nodes[2];
		nodes[0].right = nodes[3];
		nodes[1].right = nodes[4];
		return root;
	}
}
