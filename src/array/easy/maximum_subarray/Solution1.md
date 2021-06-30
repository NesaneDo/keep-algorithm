> 解法一：暴力循环

使用双重循环，实时记录遍历时的最大值

> 参考代码：

````````````````````java
public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
        int t = 0;
        for (int j = i; j < nums.length; j++) {
            t += nums[j];
            if (t > max) {
                max = t;
            }
        }
    }
    return max;
}
````````````````````

$$
时间复杂度：O(n^2)
$$

$$
空间复杂度：O(1)
$$



