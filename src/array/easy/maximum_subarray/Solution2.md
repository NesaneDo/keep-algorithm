> 解法二：动态规划

要找出整个长度为 n 的数组的最大和，则在长度为 n-1 时找到的和也必须是最大的。使用数组 dp 来记录每步的最大和，所以状态转移方程可以为：
$$
dp[n]=\begin{cases} dp[0]=nums[0]\\ max(dp[n-1]+nums[n],nums[n]),\quad n>0\end{cases}
$$

> 例：
>
> | 原数组 | -1   | -2   | 4       | -1   |
> | :----- | :--- | ---- | ------- | ---- |
> | dp     | -1   | -1   | **`4`** | 4    |



**提示：**`由于在计算 nums[i] 时只用到 dp[i-1],所以只用一个变量也可以。`



参考代码：

```java
public int maxSubArray(int[] nums) {
    // 题目已经规定 nums.length>=1
    int dp = nums[0];
    int max = dp;
    for (int i = 1; i < nums.length; i++) {
        dp = Math.max(dp + nums[i], nums[i]);
        max = Math.max(dp, max);
    }
    return max;
}
```

$$
\begin{cases}时间复杂度：O(n)\\ 空间复杂度：O(1) \end{cases}
$$

