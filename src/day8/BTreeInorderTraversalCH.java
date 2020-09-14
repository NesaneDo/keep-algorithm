package day8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BTreeInorderTraversalCH {
	public static void main(String[] args) {
		BTreeInorderTraversalCH bTreeInorderTraversalCH = new BTreeInorderTraversalCH();
		TreeNode root = bTreeInorderTraversalCH.new TreeNode(-1).getTestData();
//		System.out.println(bTreeInorderTraversalCH.inorderTraversal(root));
		System.out.println(bTreeInorderTraversalCH.inorderTraversal1(root));

	}

	/**
	 * 使用递归
	 * 
	 * @author Rondo
	 * @date 2020年9月14日 下午5:08:25
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		recursive(res, root);
		return res;
	}

	/**
	 * 使用迭代 ，使用栈（递归也相当于维护的一个栈）
	 * 
	 * @author Rondo
	 * @date 2020年9月14日 下午5:08:34
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Deque<TreeNode> stack=new ArrayDeque<TreeNode>();
		while(root!=null||!stack.isEmpty()) {
			while(root!=null) { // 遍历左子节点
				stack.push(root);
				root=root.left;
			} // 左子节点遍历完成
			root=stack.pop();
			res.add(root.val);
			root=root.right;
		}
		return res;
	}

	private void recursive(List<Integer> res, TreeNode root) {
		if (root != null) {
			recursive(res, root.left);
			res.add(root.val);
			recursive(res, root.right);
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
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
	}
}
