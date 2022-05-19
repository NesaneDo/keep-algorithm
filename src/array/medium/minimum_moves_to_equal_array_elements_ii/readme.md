### 题目

#### [462. Minimum Moves to Equal Array Elements II](https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/)

难度中等

Given an integer array `nums` of size `n`, return *the minimum number of moves required to make all array elements equal*.

In one move, you can increment or decrement an element of the array by `1`.

Test cases are designed so that the answer will fit in a **32-bit** integer.

 

**Example 1:**

```
Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
```

**Example 2:**

```
Input: nums = [1,10,2,9]
Output: 16
```

 

**Constraints:**

- `n == nums.length`
- `1 <= nums.length <= 105`
- `-109 <= nums[i] <= 109`



### 解法

1. 排序，找中位数

   为什么是中位数而不是平均数？首先答案一定在数组的最小值 min 与最大值之间 max。假设答案在 (min, max) 之外，则数组的中位数的移动次数会占一部分，而在 (min, max) 之内，至少 中位数的移动次数会更低，直到选择的数是 中位数时，中位数占的移动次数为 0

   **参考代码：**

   ```java
   public int minMoves2(int[] nums) {
       int n = nums.length, ans = 0;
       Arrays.sort(nums);
       for (int i : nums) {
           ans += Math.abs(i - nums[n / 2]);
       }
       return ans;
   }
   ```

   **复杂度：**
   $$
   \begin{cases}时间复杂度：O(n \log n)，排序耗时是 n \log n，遍历一遍耗费 n \\\\空间复杂度：O(1) \end{cases}
   $$
   

2. 快速选择，参考 [官方题解](https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/solution/zui-shao-yi-dong-ci-shu-shi-shu-zu-yuan-xt3r2/)