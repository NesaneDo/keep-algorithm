> 解法一：使用临时数组

因为方法没有返回值，需要使用一个数组把原数组复制下来。

细节1：`k%=len`，这是防止出现 `k > 数组长度 ` 的情况

细节2：`nums[i]=temp[j%=len]`，`j` 从 `len-k` 开始，直到数组结尾，`j%len` 会让 `j` 到达数组末尾时从又 `0` 开始

如：

```java
nums = [1, 2, 3, 4, 5, 6, 7], k = 3
j = len - k = 4, 所以会从 nums[4] = 5 开始，j++, 直到 j = 6 到达原数组末尾，j++ 后 j % len = 0
```



**参考代码：**

```java
public void rotate(int[] nums, int k) {
    int len=nums.length;
    // 防止出现 k > len 的情况
    k%=len;
    int[] temp=new int[len];
    System.arraycopy(nums, 0, temp, 0, len);
    for(int i=0,j=len-k;i<len;i++,j++){
        // j%=len：j 从 len-k 开始，就是开始分割数组的地方，到达数组末尾时即 j%len==0 的时候，从头开始
        nums[i]=temp[j%=len];
    }
}
```

**复杂度分析：**
$$
\begin{cases}时间复杂度：O(n)，遍历一次数组 \\空间复杂度：O(n)，使用了与原数组相等长度的额外空间 \end{cases}
$$
