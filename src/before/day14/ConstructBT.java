package before.day14;

import util.TreeNode;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * @author Rondo rondo_eleven@163.com
 * @version
 * @date 2020年9月25日 上午7:12:35
 */
public class ConstructBT {
	public static void main(String[] args) {
		int[] inorder = new int[] { 1,2,3,4,5,6,7 };
		int[] postorder = new int[] {1,3,2,5,7,6,4 };
//		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
//		int[] postorder = new int[] { 9, 15, 7, 20, 3 };
		ConstructBT bt = new ConstructBT();
		TreeNode root = bt.buildTree(inorder, postorder);
		root.postorderPrint(root);

	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		end=postorder.length-1;
		return recursion(postorder,inorder);
	}
	int end;
	private TreeNode recursion(int[] originalPostorder,  int[] sliced) {
		if (sliced==null||end < 0) {
			return null;
		}
		int rootVal = originalPostorder[end--];
		int rootIndex = getRootIndex(sliced, rootVal); // 找到根节点在中序遍历中的位置，该位置左边即左子树，右边即右子树
		if (rootIndex == -1) {
			return null;
		}
		TreeNode root = new TreeNode(rootVal);
		// 先右
		int[] postorder = slice(sliced, rootIndex + 1, sliced.length - 1);
		TreeNode right = recursion(originalPostorder, postorder);
		root.right = right;
		// 后左
		int[] inorder = slice(sliced, 0, rootIndex - 1);
		TreeNode left = recursion(originalPostorder,  inorder);
		root.left = left;
		return root;
	}

	private int[] slice(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int[] res = new int[end - start + 1];
		for (int i = start, j = 0; i <= end; i++, j++) {
			res[j] = arr[i];
		}
		return res;
	}

	private int getRootIndex(int[] inorder, int x) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == x) {
				return i;
			}
		}
		return -1;
	}

}
