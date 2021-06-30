> 解法三：贪心算法

遍历数组，记录当前的和 sum，如果 sum < 0, 则重新开始计算。

**参考代码：**

```java
public int maxSubArray(int[] nums) {
    int max=Integer.MIN_VALUE;
    int sum=0;
    for (int n:nums){
        if (sum<0){
            sum=n;
        }else{
            sum+=n;
        }
        max=Math.max(max,sum);
    }
    return max;
}
```

