### 题目

#### [497. Random Point in Non-overlapping Rectangles](https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/)

难度中等

You are given an array of non-overlapping axis-aligned rectangles `rects` where `rects[i] = [ai, bi, xi, yi]` indicates that `(ai, bi)` is the bottom-left corner point of the `ith` rectangle and `(xi, yi)` is the top-right corner point of the `ith` rectangle. Design an algorithm to pick a random integer point inside the space covered by one of the given rectangles. A point on the perimeter of a rectangle is included in the space covered by the rectangle.

Any integer point inside the space covered by one of the given rectangles should be equally likely to be returned.

**Note** that an integer point is a point that has integer coordinates.

Implement the `Solution` class:

- `Solution(int[][] rects)` Initializes the object with the given rectangles `rects`.
- `int[] pick()` Returns a random integer point `[u, v]` inside the space covered by one of the given rectangles.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2021/07/24/lc-pickrandomrec.jpg)

```
Input
["Solution", "pick", "pick", "pick", "pick", "pick"]
[[[[-2, -2, 1, 1], [2, 2, 4, 6]]], [], [], [], [], []]
Output
[null, [1, -2], [1, -1], [-1, -2], [-2, -2], [0, 0]]

Explanation
Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
solution.pick(); // return [1, -2]
solution.pick(); // return [1, -1]
solution.pick(); // return [-1, -2]
solution.pick(); // return [-2, -2]
solution.pick(); // return [0, 0]
```

 

**Constraints:**

- `1 <= rects.length <= 100`
- `rects[i].length == 4`
- `-109 <= ai < xi <= 109`
- `-109 <= bi < yi <= 109`
- `xi - ai <= 2000`
- `yi - bi <= 2000`
- All the rectangles do not overlap.
- At most `104` calls will be made to `pick`.

# 解法

1. 前缀和 + 二分
   为了方便，我们使用 rs 来代指 rects，定义某个矩阵内整数点的数量为「面积」。

   一个朴素的想法是「先随机使用哪个矩形，再随机该矩形内的点」，其中后者是极其容易的，根据矩形特质，只需在该矩形的 XY 坐标范围内随机即可确保等概率，而前者（随机使用哪个矩形）为了确保是等概率，我们不能简单随机坐标，而需要结合面积来做。

   具体的，我们可以预处理前缀和数组 sum（前缀和数组下标默认从 11 开始），其中 sum[i]sum[i] 代表前 ii 个矩形的面积之和（即下标范围 [0, i - 1][0,i−1] 的面积总和），最终 sum[n]sum[n] 为所有矩形的总面积，我们可以在 [1, sum[n]][1,sum[n]] 范围内随机，假定随机到的值为 valval，然后利用 sum 数组的具有单调性，进行「二分」，找到 valval 所在的矩形（每个矩形均会贡献面积，可看做是每个矩形在数轴 [1, sum[n]][1,sum[n]] 内贡献一段长度为面积的连续段，我们二分是为了找到点 valval 所在的连续段是由哪个矩形所贡献），然后在该矩形中进行随机，得到最终的随机点。

   > 作者：AC_OIer
   > 链接：https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/solution/by-ac_oier-mhi6/
   > 来源：力扣（LeetCode）
   > 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

   **参考代码：**

   ```java
   public class Solution {
       int[][] rs;
       int[] preSum;
       Random random = new Random();
   
       public Solution(int[][] rects) {
           rs = rects;
           preSum = new int[rs.length + 1];
           for (int i = 1; i <= rects.length; i++) {
               preSum[i] = preSum[i - 1] + (rs[i - 1][2] - rs[i - 1][0] + 1) * (rs[i - 1][3] - rs[i - 1][1] + 1);
           }
       }
   
       public int[] pick() {
           int v = random.nextInt(preSum[rs.length]) + 1;
           int l = 0, r = rs.length, mid;
           while (l < r) {
               mid = l + r >> 1;
               if (preSum[mid] >= v) {
                   r = mid;
               } else {
                   l = mid + 1;
               }
           }
           int[] cur = rs[r - 1];
           return new int[]{random.nextInt(cur[2] - cur[0] + 1) + cur[0], random.nextInt(cur[3] - cur[1] + 1) + cur[1]};
       }
   }
   ```

   **复杂度：**
   $$
   \begin{cases}
   时间复杂度：令 nn 为给定的 rs 数组长度。初始化 Solution 时需要预处理前缀和数组，复杂度为 O(n)O(n)；每次 pick 时需要在矩形个数 nn 范围内进行二分，复杂度为 O(\log{n})O(logn)
    \\\\ 
   空间复杂度：O(n) 
    \end{cases}
   $$
   