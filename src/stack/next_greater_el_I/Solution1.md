> **思路 1：暴力循环**

nums1 是 nums2 的子集，即 nums2 中所有元素来自于 nums2，且是没有重复的。

要想找到 nums2 中元素比 nums1 中下一个更大的值，就要先找到 nums2 中元素和 nums1 中相等的，并把当前 nums2 的索引记录下来，记得先定义一个 nums2 长度 - 1 的变量 n2，

然后继续里层循环，若当前里层的 nums2[j] 大于外层的 nums1[i]，则再去判断当前的 j 是否大于 n2，若大于说明该 nums2[j] 是 num[i] 的下一个更大元素



**时间复杂度: O(nm)**

**时间复杂度: O(1)**

**参考代码**

```java
public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;
            int n2 = nums2.length - 1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    n2 = j;
                }
                if (nums2[j] > nums1[i] && j > n2) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }
```

