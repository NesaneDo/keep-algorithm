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
\begin{cases} 时间复杂度：O(nlogn)，排序的复杂度 \\\\ 空间复杂度：O(n)，排序使用的额外的空间\end{cases}
$$



> 解法二：Boyer-Moore 投票算法

维护一个预候选人 **`candidate`** 和它出现的次数 **`count`**。初始时 **`candidate`** 可以为任意值，**`count`** 为 **`0`**；

遍历数组 **`nums`** 中的所有元素，对于每个元素 **`x`**，在判断 **`x`** 之前，如果 **`count`** 的值为 **`0`**，先将 **`x`** 的值赋予 **`candidate`**，随后判断 **`x`**：

如果 **`x`** 与 **`candidate`** 相等，那么计数器 **`count`** 的值增加 **`1`**；

如果 **`x`** 与 **`candidate`** 不等，那么计数器 **`count`** 的值减少 **`1`**。

在遍历完成后，**`candidate`** 即为整个数组的超过半数的数

**参考代码：**

```java
public int majorityElement(int[] nums) {
    int candidate = nums[0], count = 1;
    for (int i = 1; i < nums.length; i++) {
        if (count == 0) {
            candidate = nums[i];
        }
        count += candidate == nums[i] ? 1 : -1;
    }
    return candidate;
}
```

$$
\begin{cases} 时间复杂度：O(n) \\\\ 空间复杂度：O(1) \end{cases}
$$

