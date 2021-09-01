package tree.easy.same_tree;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 相同的树
 * @author Rondo Chan
 * @desc 相同的树
 * @since 2021/9/1
 * @version 1.0.0
 */
public class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 广度优先
        Queue<TreeNode> tmpQueue = new LinkedList<TreeNode>();
        tmpQueue.offer(p);
        tmpQueue.offer(q);
        while(!tmpQueue.isEmpty()){
            p = tmpQueue.poll();
            q = tmpQueue.poll();
            if(p == null && q == null){
                continue;
            }
            if((p == null || q == null) || p.val != q.val){
                return false;
            }
            tmpQueue.offer(p.left);
            tmpQueue.offer(q.left);

            tmpQueue.offer(p.right);
            tmpQueue.offer(q.right);
        }
        return true;
    }
}
