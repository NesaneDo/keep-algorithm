> 解法一：保存遍历的值

使用数组或类似方法保存各节点的值，再对比保存后的值是否相等。
$$
\begin{cases} 时间复杂度：O(n)，遍历三次：3*n\\\\空间复杂度:O(n)，需要保存遍历的值 \end{cases}
$$


> 解法二：深度优先搜索

从两个树根节点开始，使用相同遍历方式（如：先序遍历）遍历各节点，值相等继续，不相等则直接返回 false，直到遍历完成
$$
\begin{cases} 时间复杂度：O(min(m,n))，最多是两个树相同的情况，会遍历到最后一个节点\\\\空间复杂度:O(min(m,n))，取决于调用深度 \end{cases}
$$
**参考代码：**

```java
public boolean isSameTree(TreeNode p, TreeNode q) {
        if(null!=p&&null!=q){
            if(p.val==q.val){
                return isSameTree(p,q)&&isSameTree(p,q);
            }else{
                return false;
            }
        }else {
            return null == p && null == q;
        }
    }
```

> 解法三：广度优先搜索

使用一个队列保存遍历的**两个值**，每次取**两个值**进行比较。
$$
\begin{cases} 时间复杂度：O(min(m,n))，m，n分别是两个树的节点数\\\\空间复杂度:O(min(m,n))，队列中元素不会超过更少树的节点数 \end{cases}
$$


**参考代码：**

```java
public boolean isSameTree(TreeNode p, TreeNode q) {
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
```

