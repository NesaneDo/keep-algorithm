package tree.medium.find_bottom_left_tree_value;

import util.TreeNode;

/**
 * LeetCode 513. Find Bottom Left Tree Value
 * @author Rondo Chan
 * @desc LeetCode 513. Find Bottom Left Tree Value
 * @since 2022/6/22
 * @version 1.0.0
 */
public class Solutions {
    int maxLevel;
    int target;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return target;
    }
    void dfs(TreeNode root, int level){
        if(root==null)return;
        dfs(root.right,++level);
        dfs(root.left,level);
        if(level>=maxLevel){
            maxLevel=level;
            target=root.val;
        }
    }
}
