package tree.easy.convert_sorted_array_to_binary_search_tree;

import util.TreeNode;

/**
 * LeetCode 108. Convert Sorted Array to Binary Search Tree
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 108. Convert Sorted Array to Binary Search Tree
 * @since 2022/5/26
 */
public class Solutions {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    /**
     * 每次取 nums 中间的元素作为根节点
     */
    TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }
}

