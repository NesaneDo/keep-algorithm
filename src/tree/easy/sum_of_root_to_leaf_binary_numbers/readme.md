### 题目

#### [1022. Sum of Root To Leaf Binary Numbers](https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/)

难度简单156收藏分享切换为中文接收动态反馈

You are given the `root` of a binary tree where each node has a value `0` or `1`. Each root-to-leaf path represents a binary number starting with the most significant bit.

- For example, if the path is `0 -> 1 -> 1 -> 0 -> 1`, then this could represent `01101` in binary, which is `13`.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return *the sum of these numbers*.

The test cases are generated so that the answer fits in a **32-bits** integer.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2019/04/04/sum-of-root-to-leaf-binary-numbers.png)

```
Input: root = [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
```

**Example 2:**

```
Input: root = [0]
Output: 0
```

 

**Constraints:**

- The number of nodes in the tree is in the range `[1, 1000]`.
- `Node.val` is `0` or `1`.

### 解法

1. 递归

   使用递归进行求解，将每次递归的值往左移一位（相当于乘以 2 ）以给当前节点留出最后一位，再把当前节点中的值加到最后一位即可

   **参考代码：**

   ```java
   public int sumRootToLeaf(TreeNode root) {
       return dfs(root, 0);
   }
   
   int dfs(TreeNode node, int sum) {
       if (node == null) {
           return 0;
       }
       // 将原值左移 1 位，即乘 2，再加上当前节点的值
       sum = (sum << 1) | node.val;
       if (node.left == null && node.right == null) {
           return sum;
       }
       return dfs(node.left, sum) + dfs(node.right, sum);
   }
   ```

   **复杂度：**
   $$
   \begin{cases}时间复杂度：O(n)，需要遍历到每个节点\\\\空间复杂度：O(n)，如果不算栈空间为 O(1)\end{cases}
   $$

2. 迭代

   遍历时把当前节点的值保存到下一个要遍历的节点里，当下个节点被遍历时，将当前节点的值左移 1 位后再加上下个节点的值，直到遍历完成。

   **参考代码：**

   ```java
   public int sumRootToLeaf2(TreeNode root) {
       Deque<TreeNode> queue = new LinkedList<>();
       int sum = 0, level = 1;
       queue.offer(root);
       while (!queue.isEmpty()) {
           TreeNode node = queue.pollFirst();
           if (node.left != null) {
               node.left.val = (node.val << 1) | node.left.val;
               queue.offer(node.left);
           }
           if (node.right != null) {
               node.right.val = (node.val << 1) | node.right.val;
               queue.offer(node.right);
           }
           if (node.left == null && node.right == null) {
               sum += node.val;
           }
       }
       return sum;
   }
   ```

   **复杂度：**
   $$
   \begin{cases}时间复杂度：O(n)\\\\空间复杂度：O(n)，使用了一个队列来辅助遍历\end{cases}
   $$
   