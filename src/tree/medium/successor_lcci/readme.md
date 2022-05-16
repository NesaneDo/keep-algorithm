### 题目

#### [面试题 04.06. 后继者](https://leetcode.cn/problems/successor-lcci/)

难度中等107收藏分享切换为英文接收动态反馈

设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。

如果指定节点没有对应的“下一个”节点，则返回`null`。

**示例 1:**

```
输入: root = [2,1,3], p = 1

  2
 / \
1   3

输出: 2
```

**示例 2:**

```
输入: root = [5,3,6,2,4,null,null,1], p = 6

      5
     / \
    3   6
   / \
  2   4
 /   
1

输出: null
```

### 解法

根据二叉搜索树的性质二分搜索即可

**参考代码：**

```java
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
```

#### 复杂度

$$
\begin{cases}时间复杂度：O(logn)，最坏情况下是 O(n) \\\\ 空间复杂度：O(1) \end{cases}
$$

