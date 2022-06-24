package tree.medium.find_largest_value_in_each_tree_row;

import util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode 515. Find Largest Value In Each Tree Row
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc Leetcode 515. Find Largest Value In Each Tree Row
 * @since 2022/6/24
 */
public class Solutions {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (null == root) return ans;
        int size, max;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode cur;
        while (!q.isEmpty()) {
            size = q.size();
            max = q.peek().val;
            while (size-- > 0) {
                cur = q.pollFirst();
                max = Math.max(max, cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            ans.add(max);
        }
        return ans;
    }
}
