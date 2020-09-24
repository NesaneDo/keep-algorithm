package day13;

import java.util.Arrays;

import util.TreeNode;

public class FindModeInBST {
	int resCount; // 记录结果个数
	int curCount; // 记录当前遍历到的元素的个数
	int maxCount; // 记录 curCount 中最大的
	TreeNode pre;
	int[] res;

	public static void main(String[] args) {
		FindModeInBST bst = new FindModeInBST();
		TreeNode root = new TreeNode(0).getTestData();
		System.out.println(Arrays.toString(bst.findMode(root)));
	}

	public int[] findMode(TreeNode root) {
		if (root == null) {
			return new int[] {};
		}
		inOrder(root); // 确定结果大小
		pre = null;
		res = new int[resCount];
		curCount = 0;
		resCount = 0;
		inOrder(root); // 确定结果
		return res;
	}

	private void inOrder(TreeNode node) {
		if (node == null)
			return;

		inOrder(node.left);
		if (pre != null && pre.val == node.val) {
			curCount++;
		} else { // 遍历到不同于之前的数字：重置为 1
			curCount = 1;
		}
		
		if (curCount > maxCount) {
			maxCount = curCount;
			resCount = 1;
		}else if (curCount == maxCount) { // 第一次遍历时不会执行，因为 res 数组还没有初始化
			if (res != null) {
				res[resCount] = node.val;
			}
			resCount++;
		}
		
		pre = node;
		inOrder(node.right);
	}

}
