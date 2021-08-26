> 解法一：双指针

两个数组从末尾开始遍历，判断大小，将较大的值置于 **nums1** 的末尾，并将较大值所在的数组的下标 **减1**，直到完成遍历，为了防止出现 **nums2** 中元素全部大于 **nums1** 中的元素，遍历完成后还需再进行一次遍历，将 **nums2** 中的元素依次放到 **nums1** 中，参考代码如下：

**参考代码：**

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (m == 0) {
        if (n >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }
        return;
    }
    int len = nums1.length;
    int i = n - 1, j = m - 1;
    while (i>=0&&j>=0) {
        if (nums1[j] <= nums2[i]) {
            nums1[--len] = nums2[i--];
        } else {
            nums1[--len] = nums1[j--];
        }
    }
    while(j<i){
        nums1[--len]=nums2[i--];
    }
}
```

$$
\begin{cases} 时间复杂度：O(m+n) \\\\空间复杂度：O(1) \end{cases}
$$

