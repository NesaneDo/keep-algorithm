### 题目

#### [436. Find Right Interval](https://leetcode.cn/problems/find-right-interval/)

难度中等155收藏分享切换为中文接收动态反馈

You are given an array of `intervals`, where `intervals[i] = [starti, endi]` and each `starti` is **unique**.

The **right interval** for an interval `i` is an interval `j` such that `startj >= endi` and `startj` is **minimized**. Note that `i` may equal `j`.

Return *an array of **right interval** indices for each interval `i`*. If no **right interval** exists for interval `i`, then put `-1` at index `i`.

 

**Example 1:**

```
Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.
```

**Example 2:**

```
Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
Explanation: There is no right interval for [3,4].
The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
```

**Example 3:**

```
Input: intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]
Explanation: There is no right interval for [1,4] and [3,4].
The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
```

 

**Constraints:**

- `1 <= intervals.length <= 2 * 104`
- `intervals[i].length == 2`
- `-106 <= starti <= endi <= 106`
- The start point of each interval is **unique**.



### 解法

1. 利用 `TreeMap` 的特性

   用 TreeMap 的特性，给 intervals[i][0] 排序，再利用内置的获取大于等于 intervals[i][1] 的最小的元素

   **参考代码：**

   ```java
   public int[] findRightInterval(int[][] intervals) {
       int[] ans = new int[intervals.length];
       TreeMap<Integer, Integer> map = new TreeMap<>();
       for (int i = 0; i < ans.length; i++) {
           map.put(intervals[i][0], i);
       }
       for (int i = 0; i < ans.length; i++) {
           Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
           ans[i] = entry == null ? -1 : entry.getValue();
       }
       return ans;
   }
   ```

   $$
   \begin{cases}时间复杂度：O(n\log n)，添加和查询均为 \log n \\\\空间复杂度：O(n) \end{cases}
   $$

   

2. 【待完善】