### 题目

#### [668. Kth Smallest Number in Multiplication Table](https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/)

难度困难195收藏分享切换为中文接收动态反馈

Nearly everyone has used the [Multiplication Table](https://en.wikipedia.org/wiki/Multiplication_table). The multiplication table of size `m x n` is an integer matrix `mat` where `mat[i][j] == i * j` (**1-indexed**).

Given three integers `m`, `n`, and `k`, return *the* `kth` *smallest element in the* `m x n` *multiplication table*.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2021/05/02/multtable1-grid.jpg)

```
Input: m = 3, n = 3, k = 5
Output: 3
Explanation: The 5th smallest number is 3.
```

**Example 2:**

![img](https://assets.leetcode.com/uploads/2021/05/02/multtable2-grid.jpg)

```
Input: m = 2, n = 3, k = 6
Output: 6
Explanation: The 6th smallest number is 6.
```

 

**Constraints:**

- `1 <= m, n <= 3 * 104`
- `1 <= k <= m * n`



> #### [668. 乘法表中第k小的数](https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/)
>
> 难度困难195收藏分享切换为英文接收动态反馈
>
> 几乎每一个人都用 [乘法表](https://baike.baidu.com/item/乘法表)。但是你能在乘法表中快速找到第`k`小的数字吗？
>
> 给定高度`m` 、宽度`n` 的一张 `m * n`的乘法表，以及正整数`k`，你需要返回表中第`k` 小的数字。
>
> **例 1：**
>
> ```
> 输入: m = 3, n = 3, k = 5
> 输出: 3
> 解释: 
> 乘法表:
> 1	2	3
> 2	4	6
> 3	6	9
> 
> 第5小的数字是 3 (1, 2, 2, 3, 3).
> ```
>
> **例 2：**
>
> ```
> 输入: m = 2, n = 3, k = 6
> 输出: 6
> 解释: 
> 乘法表:
> 1	2	3
> 2	4	6
> 
> 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
> ```
>
> **注意：**
>
> 1. `m` 和 `n` 的范围在 [1, 30000] 之间。
> 2. `k` 的范围在 [1, m * n] 之间。



### 解法

1. 暴力解法

   **参考代码：**

   ```java
   public int findKthNumber1(int m, int n, int k) {
       int[] nums = new int[m * n];
       int t = 0;
       for (int i = 1; i <= m; i++) {
           for (int j = 1; j <= n; j++) {
               nums[t++] = i * j;
           }
       }
       Arrays.sort(nums);
       return nums[k];
   }
   ```

   **复杂度：**
   $$
   \begin{cases}时间复杂度：O(m*n) \\\\空间复杂度：O(m*n) \end{cases}
   $$
   

2. 二分查找

   由于 m 和 n 很大，直接求出所有数字然后找到第 k 小会超出时间限制。不妨考虑一个反向问题：对于乘法表中的数字 x，它是乘法表中第几小的数字？

   求第几小等价于求有多少数字不超过 x。我们可以遍历乘法表的每一行，对于乘法表的第 i 行，其数字均为 i 的倍数，因此不超过 x 的数字有 $ \min(\Big\lfloor\dfrac{x}{i}\Big\rfloor,n)$ 个，所以整个乘法表不超过 x 的数字个数为
   $$
   \sum_{i=1}^{m} \min(\Big\lfloor\dfrac{x}{i}\Big\rfloor,n)
   $$
   由于 $i\le \Big\lfloor\dfrac{x}{n}\Big\rfloor$ 时$\Big\lfloor\dfrac{x}{i}\Big\rfloor \ge n$，上式可化简为
   $$
   \Big\lfloor\dfrac{x}{n}\Big\rfloor\cdot n + \sum_{i=\Big\lfloor\dfrac{x}{n}\Big\rfloor+1}^{m} \Big\lfloor\dfrac{x}{i}\Big\rfloor
   $$
   

   由于 x 越大上式越大，x 越小上式越小，因此我们可以二分 x 找到答案，二分的初始边界为乘法表的元素范围，即 \[1,mn\]。

   > 作者：LeetCode-Solution
   > 链接：https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/solution/cheng-fa-biao-zhong-di-kxiao-de-shu-by-l-521a/
   > 来源：力扣（LeetCode）

   **参考代码：**

   ```java
   public int findKthNumber2(int m, int n, int k) {
       int left = 1, right = m * n;
       while (left < right) {
           int x = left + (right - left) / 2;
           int count = x / n * n;
           for (int i = x / n + 1; i <= m; ++i) {
               count += x / i;
           }
           if (count >= k) {
               right = x;
           } else {
               left = x + 1;
           }
       }
       return left;
   }
   ```

   **复杂度：**
   $$
   \begin{cases}时间复杂度：O(m\log mn) \\\\空间复杂度：O(1) \end{cases}
   $$
   