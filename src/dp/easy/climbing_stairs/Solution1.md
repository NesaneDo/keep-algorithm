> 解法一：典型的动态规划题

子问题：爬第 n 个台阶时，只能从第 n-1 或 n-2 的台阶爬，而 n = 1 或 n = 2 时，f(n) = n。所以状态转移方程就是：
$$
f(n)=\begin{cases}n,\quad n=1或n=2\\f(n-1)+f(n-2), \quad n>2\end{cases}
$$
**参考代码1：**

```java
public int climbStairs(int n) {
    if (n < 3) {
        return n;
    }
    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n - 1];
}
```

$$
\begin{cases}时间复杂度：O(n)\\空间复杂度：O(n)\end{cases}
$$

> 提示：因为只用到 dp 数组的两个值，所以空间复杂度可以优化为：O(1)

**参考代码2：**

```java
public int climbStairs(int n) {
    if (n < 3) {
        return n;
    }
    int t1 = 1,t2=2;
    int res=t1+t2;
    for (int i = 3; i <= n; i++) {
        res=t1+t2;
        t1=t2;
        t2=res;
    }
    return res;
}
```

$$
\begin{cases}时间复杂度：O(n)\\空间复杂度：O(1)\end{cases}
$$

