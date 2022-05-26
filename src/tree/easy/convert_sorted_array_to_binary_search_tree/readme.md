### 题目

#### [108. Convert Sorted Array to Binary Search Tree](https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/)

难度简单1046收藏分享切换为中文接收动态反馈

Given an integer array `nums` where the elements are sorted in **ascending order**, convert *it to a **height-balanced** binary search tree*.

A **height-balanced** binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2021/02/18/btree1.jpg)

```
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:
```

**Example 2:**

![img](https://assets.leetcode.com/uploads/2021/02/18/btree.jpg)

```
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
```

 

**Constraints:**

- `1 <= nums.length <= 104`
- `-104 <= nums[i] <= 104`
- `nums` is sorted in a **strictly increasing** order.



### 解法

1. 递归

   因为数组严格递增，所以可以每次选取数组中间的元素作为根节点，并连续递归

   **参考代码：**

   ```java
   public TreeNode sortedArrayToBST(int[] nums) {
       return dfs(nums, 0, nums.length - 1);
   }
   
   /**
        * 每次取 nums 中间的元素作为根节点
        */
   TreeNode dfs(int[] nums, int left, int right) {
       if (left > right) {
           return null;
       }
       int mid = (left + right) / 2;
       TreeNode root = new TreeNode(nums[mid]);
       root.left = dfs(nums, left, mid - 1);
       root.right = dfs(nums, mid + 1, right);
       return root;
   }
   ```

   **复杂度：**
   $$
   \begin{cases}时间复杂度：O(n) \\\\空间复杂度：O(1),如果算递归栈则为 O(n) \end{cases}
   $$
   

   