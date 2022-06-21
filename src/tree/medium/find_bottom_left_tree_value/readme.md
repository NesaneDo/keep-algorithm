### 题目

#### [513. Find Bottom Left Tree Value](https://leetcode.cn/problems/find-bottom-left-tree-value/)

难度中等

Given the `root` of a binary tree, return the leftmost value in the last row of the tree.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2020/12/14/tree1.jpg)

```
Input: root = [2,1,3]
Output: 1
```

**Example 2:**

![img](https://assets.leetcode.com/uploads/2020/12/14/tree2.jpg)

```
Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
```

 

**Constraints:**

- The number of nodes in the tree is in the range `[1, 104]`.
- `-231 <= Node.val <= 231 - 1`

### 解法

本题实际是获取树的最大深度

1. 深度遍历

   从左到右或者从右到左使用 **DFS** 深度遍历，记录最大的深度和节点值，遍历完成返回最大深度的节点值即可。

   **参考代码：**

   ```java
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
   ```

   **复杂度**
   $$
   \begin{cases}
   时间复杂度：O(n)，需要遍历所有节点
   \\\\
   空间复杂度：O(1)，只使用了2个变量
   \end{cases}
   $$
   

   