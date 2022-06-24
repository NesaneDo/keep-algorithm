### 题目

#### [515. Find Largest Value in Each Tree Row](https://leetcode.cn/problems/find-largest-value-in-each-tree-row/)

难度中等

Given the `root` of a binary tree, return *an array of the largest value in each row* of the tree **(0-indexed)**.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2020/08/21/largest_e1.jpg)

```
Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
```

**Example 2:**

```
Input: root = [1,2,3]
Output: [1,3]
```

 

**Constraints:**

- The number of nodes in the tree will be in the range `[0, 104]`.
- `-231 <= Node.val <= 231 - 1`

### 解法

1. BFS，记录每层最大值

   **参考代码：**

   ```java
   public class Solutions {
       public List<Integer> largestValues(TreeNode root) {
           List<Integer> ans = new LinkedList<>();
           if (null == root) return ans;
           int size, max;
           Deque<TreeNode> q = new LinkedList<>();
           q.offer(root);
           TreeNode cur;
           while (!q.isEmpty()) {
               size = q.size();
               max = q.peek().val;
               while (size-- > 0) {
                   cur = q.pollFirst();
                   max = Math.max(max, cur.val);
                   if (cur.left != null) q.offer(cur.left);
                   if (cur.right != null) q.offer(cur.right);
               }
               ans.add(max);
           }
           return ans;
       }
   }
   
   ```

   **复杂度：**
   $$
   \begin{cases}
   时间复杂度：O(n)
   \\\\
   空间复杂度：O(n)
   \end{cases}
   $$
   