package day11;

public class BST2GT {
	public static void main(String[] args) {
		BST2GT bst2gt = new BST2GT();
		TreeNode node = bst2gt.new TreeNode(-1).getTestData();
		TreeNode res = bst2gt.convertBST(node);
		node.inorderPrint(res);
	}

	int sum = 0;

	/**
	 * 需要了解二叉搜索树的特点：中序遍历是递增的，则逆序中序遍历是递减的
	 * 
	 * @author Rondo
	 * @date 2020年9月21日 上午8:25:40
	 * @param root
	 * @return
	 */
	public TreeNode convertBST(TreeNode root) {
		if (root == null) {
			return null;
		}
		convertBST(root.right);
		sum += root.val;
		root.val = sum;
		convertBST(root.left);
		return root;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

		public void inorderPrint(TreeNode root) {
			if (root == null) {
				return;
			}
			inorderPrint(root.left);
			System.out.print(root.val+" ");
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
			 * ******** 3 ****** 6
			 * 
			 * ****** / ** \ ***** \
			 * 
			 * *****1 ****** 2 ***** 8
			 */
			TreeNode root = new TreeNode(5);
			TreeNode[] nodes = new TreeNode[5];
			nodes[0] = new TreeNode(3);
			nodes[1] = new TreeNode(6);
			nodes[2] = new TreeNode(1);
			nodes[3] = new TreeNode(2);
			nodes[4] = new TreeNode(8);
			root.left = nodes[0];
			root.right = nodes[1];
			nodes[0].left = nodes[2];
			nodes[0].right = nodes[3];
			nodes[1].right = nodes[4];
			return root;
		}
	}

}
