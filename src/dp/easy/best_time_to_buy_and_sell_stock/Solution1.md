> 解法一：双重循环(会超时)

循环遍历数组，并记录最大值。

**参考代码：**

```java
public int maxProfit(int[] prices) {
    int max = 0;
    for (int i = 0; i < prices.length; i++) {
        for (int j = i + 1; j < prices.length; j++) {
            max = Math.max(prices[j] - prices[i], max);
        }
    }
    return max;
}
```

**复杂度分析：**
$$
\begin{cases} 时间复杂度：O(n^2)\\空间复杂度：O(1) \end{cases}
$$
