package day6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AVGLevelsInBTreeCH {
	public static void main(String[] args) {
		AVGLevelsInBTreeCH avgLevelsInBTreeCH = new AVGLevelsInBTreeCH();

		List<Double> res = avgLevelsInBTreeCH.averageOfLevels1(avgLevelsInBTreeCH.new TreeNode(1).getTestData());
		System.out.println(res);
	}

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<Double>();
		Deque<TreeNode> q = new ArrayDeque<TreeNode>();
		if (root == null)
			return res;
		q.offer(root);
		while (!q.isEmpty()) { // 广度优先搜索
			int size = q.size();
			double sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				sum += node.val;
				TreeNode left = node.left, right = node.right;
				if (left != null)
					q.offer(left);
				if (right != null)
					q.offer(right);
			}
			res.add(sum / size);
		}
		return res;
	}

	/**
	 * 使用两个数组，分别每层数据的总和和数字个数
	 * 
	 * @author Rondo
	 * @date 2020年9月12日 下午5:01:08
	 * @param root
	 * @return
	 */
	public List<Double> averageOfLevels1(TreeNode root) {
		List<Double> res = new ArrayList<Double>();
		List<Double> sum = new ArrayList<Double>(); // 记录层数字 sum
		List<Integer> count = new ArrayList<Integer>(); // 记录层数字个数
		if (root == null) {
			return res;
		}
		sum.add(1.0*root.val);
		count.add(1);
		dfs(sum, count, root, 0);
		for (int i = 0; i < sum.size(); i++) {
			res.add(sum.get(i) / count.get(i));
		}
		return res;
	}

	/**
	 * 深度优先搜索
	 * 
	 * @author Rondo
	 * @date 2020年9月12日 下午5:08:08
	 * @param sum
	 * @param count
	 * @param root
	 * @param level
	 */
	private void dfs(List<Double> sum, List<Integer> count, TreeNode root, int level) {
		if (root == null)
			return;
		if (level < sum.size()) {
			sum.set(level, sum.get(level) + root.val);
			count.set(level, count.get(level) + 1);
		} else {
			sum.add(1.0*root.val);
			count.add(1);
		}
		dfs(sum, count, root.left, level+1);
		dfs(sum, count, root.right, level+1);

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
			 * 测试数据 5 / \ 8 6 / \ \ 3 3 6
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
