> 解法一：排序

先将数组升序排序，遍历数组，将数组中的 $$k$$ 个负数反转，若负数不足 $$k$$ 个，则反转全部负数， $$k$$ 需要同步减少对应个数，记录遍历时绝对值最小的值  $$x$$；可以同时记录 和 $$sum$$ ，结束遍历后，判断 $$k$$ 是否大于 $$0$$，大于则继续判断 $$k$$ 的奇偶性，为偶数不做处理，为奇数则需要减去  $$2 * x$$ 

**参考代码：**

```java
public int largestSumAfterKNegations(int[] nums, int k) {
    // 排序
    Arrays.sort(nums);
    // 记录最小绝对值，因为题目说最大为100，所以初始化为100
    int minN = 100;
    int sum = 0;
    for (int i : nums) {
        if (k > 0 && i < 0) {
            i = -i;
            k--;
        }
        minN = Math.min(i, minN);
        sum += i;
    }
    // 若负数反转完后 k>0, 则判断k的奇偶性，偶数反转两次则抵消，奇数则需要减去2倍的minN
    return sum - ((k > 0 && (k & 1) != 0) ? 2 * minN : 0);
}
```



**复杂度分析：**
$$
\begin{cases}时间复杂度：O(nlogn)，排序nlogn，遍历为n，总体为 nlogn \\\\ 空间复杂度：O(1)，只使用了常数个变量 \end{cases}
$$
