> 解法一：双指针

题目说：给定的数组是非递减的。那么平方后的数组有可能呈下图中的三种情况，即：

1. 原数组 **全部 <= 0**
2. 原数组 **全部 >= 0**
3. 原数组 **正负数都有**



|                           $y=x^2$                            |
| :----------------------------------------------------------: |
| ![image-20210714094500062](E:\Programming\Algorithm\Java\keep-algorithm\src\array\easy\squares_of_a_sorted_array\Solution1.assets\1.png) |



可能乍一看好像可以分类讨论，但仔细一想就会发现，这有三种情况可以统一：

- 声明一个长度和原数组相等的 **新数组**

- 遍历，从两头开始，平方后将数值更大的存到 **新数组** 中
- 谁的值更大，则将它的下标往另一端移动，如 **i** 和 **j** 分别是 **头指针** 和 **尾指针**, 若 $nums[i]^2 > nums[j]^2$ 则将 **i++**, 反之 **j--**
- 直到 **头指针 <= 尾指针** 结束



> **参考代码：**

```java
public int[] sortedSquares(int[] nums) {
    int len = nums.length;
    int[] res = new int[len];
    for (int i = 0, j = len - 1, k = len - 1; i <= j; ) {
        int i2 = nums[i] * nums[i];
        int j2 = nums[j] * nums[j];
        if (i2 > j2) {
            res[k--] = i2;
            i++;
        } else {
            res[k--] = j2;
            j--;
        }
    }
    return res;
}
```

