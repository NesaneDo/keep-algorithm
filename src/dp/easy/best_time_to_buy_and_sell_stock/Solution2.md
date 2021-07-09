> 解法二：一次遍历（官方）

使用一个变量 **min** 记录历史最小的值（初始化化为 Integer.MAX_VALUE），使用 **max** 记录最大利润（初始化为 0）。依次遍历**，若当前遍历的值比 **min** 大，则更新**max**，遍历完成，**max** 则为结果。



**参考代码：**

```java
public int maxProfit(int[] prices) {
    int max = 0;
    int min = Integer.MAX_VALUE;
    for (int price : prices) {
        if (price < min) {
            min = price;
        } else if (price - min > max) {
            max = price - min;
        }
    }
    return max;
}
```



**复杂度分析：**
$$
\begin{cases}时间复杂度：O(n)。只遍历一次数组 \\空间复杂度：O(1)。只使用了2个整型变量 \end{cases}
$$
