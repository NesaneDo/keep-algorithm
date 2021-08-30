> 解法一：保存遍历的值

使用数组或类似方法保存各节点的值，再对比保存后的值是否相等。
$$
\begin{cases} 时间复杂度：O(n)，遍历三次：3*n\\\\空间复杂度:O(n)，需要保存遍历的值 \end{cases}
$$


> 解法二：遍历对比同时进行

从两个树根节点开始，使用相同遍历方式（如：先序遍历）遍历各节点，值相等继续，不相等则直接返回 false，直到遍历完成
$$
\begin{cases} 时间复杂度：O(n)，最多是两个树相同的情况，会遍历到最后一个节点\\\\空间复杂度:O(1)，没有使用额外空间 \end{cases}
$$
**参考代码：**

```java
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
```

