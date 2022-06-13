### 题目

#### [1051. Height Checker](https://leetcode.cn/problems/height-checker/)

难度简单

A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in **non-decreasing order** by height. Let this ordering be represented by the integer array `expected` where `expected[i]` is the expected height of the `ith` student in line.

You are given an integer array `heights` representing the **current order** that the students are standing in. Each `heights[i]` is the height of the `ith` student in line (**0-indexed**).

Return *the **number of indices** where* `heights[i] != expected[i]`.

 

**Example 1:**

```
Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation: 
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.
```

**Example 2:**

```
Input: heights = [5,1,2,3,4]
Output: 5
Explanation:
heights:  [5,1,2,3,4]
expected: [1,2,3,4,5]
All indices do not match.
```

**Example 3:**

```
Input: heights = [1,2,3,4,5]
Output: 0
Explanation:
heights:  [1,2,3,4,5]
expected: [1,2,3,4,5]
All indices match.
```

 

**Constraints:**

- `1 <= heights.length <= 100`
- `1 <= heights[i] <= 100`

### 解法

1. 排序比较

   通过排序再依次比较即可得出结果

   **参考代码：**

   ```java
   public int heightChecker(int[] heights) {
       int[] tArr = new int[heights.length];
       System.arraycopy(heights, 0, tArr, 0, heights.length);
       Arrays.sort(tArr);
       int sum = 0;
       for (int i = 0; i < heights.length; i++) {
           sum += heights[i] == tArr[i] ? 0 : 1;
       }
       return sum;
   }
   ```

   **复杂度：**
   $$
   \begin{cases}
   时间复杂度：O(n\log n)，排序耗时
   \\\\
   空间复杂度：O(n)，使用额外的数组来保存排序后的元素
   \end{cases}
   $$
   

2. 