package util;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}

	public void inorderPrint(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderPrint(root.left);
		System.out.print(root.val + " ");
		inorderPrint(root.right);
	}

	public TreeNode getTestData() {
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
		TreeNode root = new TreeNode(5);
		TreeNode[] nodes = new TreeNode[5];
		nodes[0] = new TreeNode(1);
		nodes[1] = new TreeNode(6);
		nodes[2] = new TreeNode(1);
		nodes[3] = new TreeNode(3);
		nodes[4] = new TreeNode(6);
		root.left = nodes[0];
		root.right = nodes[1];
		nodes[0].left = nodes[2];
		nodes[0].right = nodes[3];
		nodes[1].right = nodes[4];
		return root;
	}
}