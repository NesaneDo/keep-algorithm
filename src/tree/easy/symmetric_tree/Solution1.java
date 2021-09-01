package tree.easy.same_tree.tree.easy.symmetric_tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 对称树
 * @author Rondo Chan
 * @desc 对称树
 * @since 2021/8/31
 * @version 1.0.0
 */
public class Solution1 {
    /**
     * 通过”根左右“和”根右左“的方式遍历两次，遇到 null 节点时，添加一个不存在的值，遍历结束后再对比两次的结果是否相同
     * @param root 根节点
     * @return 是否是对称树
     */
    public boolean isSymmetric(TreeNode root) {
        if(null==root){
            return true;
        }else if(null==root.left&&null==root.right){
            return true;
        }
        List<Integer> lr = new ArrayList<>();
        List<Integer> rl= new ArrayList<>();
        lr(lr,root);
        rl(rl,root);
        for(int i=0;i<lr.size();i++){
            if(!lr.get(i).equals(rl.get(i))){
                return false;
            }
        }
        return true;

    }
    private void lr(List<Integer> res,TreeNode node){
        if(null==node){
            res.add(-1);
            return;
        }
        res.add(node.val);
        lr(res,node.left);
        lr(res,node.right);
    }
    private void rl(List<Integer> res,TreeNode node){
        if(null==node){
            res.add(-1);
            return;
        }
        res.add(node.val);
        rl(res,node.right);
        rl(res,node.left);
    }
}
