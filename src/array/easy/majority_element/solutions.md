> 解法一：排序

排序后，多数的元素一定在数组中间

**参考代码：**

```java
public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length/2];
}
```

$$
\begin{cases} 时间复杂度：O(nlogn)，排序的复杂度 \\\\ \end{cases}
$$

