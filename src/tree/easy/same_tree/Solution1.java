package tree.easy.same_tree;

import util.TreeNode;

public class Solution1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(null!=p&&null!=q){
            if(p.val==q.val){
                boolean t=isSameTree(p,q);
                return t&&isSameTree(p,q);
            }else{
                return false;
            }
        }else {
            return null == p && null == q;
        }
    }
}
