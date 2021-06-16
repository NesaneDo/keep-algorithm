package stack.binary_tree_postorder_traversal;

import com.sun.jmx.remote.internal.ArrayQueue;
import util.TreeNode;

import java.util.*;

/**
 * 迭代
 * 先序遍历：根 - 左 - 右
 * 后序遍历：左 - 右 - 根
 * 先序逆序：右 - 左 - 根
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc 迭代
 * @since 2021/5/20
 */
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                res.add(0, root.val);
                root = root.right;
            } else {
                root=stack.pop();
                root=root.left;
            }
        }
        return res;
    }
}
