> 解法一：反方向遍历

通过”根左右“和”根右左“的方式遍历两次，遇到 null 节点时，添加一个不存在的值，遍历结束后再对比两次的结果是否相同
$$
\begin{cases} 时间复杂度：O(n)，需要遍历两次所有节点\\\\空间复杂度：O(n)，需要使用两个List来保存遍历结果 \end{cases}
$$
**参考代码：**

```java
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
```

