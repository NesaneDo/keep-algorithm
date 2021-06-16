package stack.binary_tree_postorder_traversal;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 递归
 * @author Rondo Chan
 * @desc
 * @since 2021/5/20
 * @version 1.0.0
 */
public class Solution1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        recursive(res,root);
        return res;
    }
    public void recursive(List<Integer> res,TreeNode root){
        if(root==null){
            return;
        }
        recursive(res,root.left);
        recursive(res,root.right);
        res.add(root.val);
    }
}
