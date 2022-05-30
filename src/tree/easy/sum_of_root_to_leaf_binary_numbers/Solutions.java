package tree.easy.sum_of_root_to_leaf_binary_numbers;

import util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LeetCode 1022. Sum of Root To Leaf Binary Numbers
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @since 2022/5/30
 */
public class Solutions {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        // 将原值左移 1 位，即乘 2，再加上当前节点的值
        sum = (sum << 1) | node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return dfs(node.left, sum) + dfs(node.right, sum);
    }

    public int sumRootToLeaf2(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        int sum = 0, level = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node.left != null) {
                node.left.val = (node.val << 1) | node.left.val;
                queue.offer(node.left);
            }
            if (node.right != null) {
                node.right.val = (node.val << 1) | node.right.val;
                queue.offer(node.right);
            }
            if (node.left == null && node.right == null) {
                sum += node.val;
            }
        }
        return sum;
    }
}
