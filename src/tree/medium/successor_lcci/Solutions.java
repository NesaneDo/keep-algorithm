package tree.medium.successor_lcci;

import util.TreeNode;

/**
 * LeetCode 面试题 04.06 后继者
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 面试题 04.06 后继者
 * @since 2022/5/16
 */
public class Solutions {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        while(root != null) {
            if(root.val > p.val){
                ans=root;
                root=root.left;
            }else{
                root=root.right;
            }
        }
        return ans;
    }
}
