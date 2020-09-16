package day10;

public class InvertBTree {
	public static void main(String[] args) {
		InvertBTree bTree = new InvertBTree();
		TreeNode root = bTree.new TreeNode(0).getTestData();
		TreeNode res = bTree.invertTree(root);
		res.print(res);
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = right;
		root.right = left;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		public TreeNode getTestData() {
			/**
			 * 测试数据
			 * 
			 * ************ 5
			 * 
			 * ********** / ** \
			 * 
			 * ******** 8 ****** 6
			 * 
			 * ****** / ** \ ***** \
			 * 
			 * *****3 ****** 3 ***** 6
			 */
			TreeNode root = new TreeNode(5);
			TreeNode[] nodes = new TreeNode[5];
			nodes[0] = new TreeNode(8);
			nodes[1] = new TreeNode(6);
			nodes[2] = new TreeNode(3);
			nodes[3] = new TreeNode(3);
			nodes[4] = new TreeNode(6);
			root.left = nodes[0];
			nodes[0].left = nodes[2];
			nodes[0].right = nodes[3];
			root.right = nodes[1];
			nodes[1].right = nodes[4];
			return root;
		}

		public void print(TreeNode root) {
			if (root == null) {
				return;
			}
			print(root.left);
			System.out.print(root.val + " ");
			print(root.right);
		}
	}

}
