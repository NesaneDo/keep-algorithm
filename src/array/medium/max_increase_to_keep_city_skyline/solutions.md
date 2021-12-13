> 解法一：遍历

有两个方向上的天际线需要保持，即左右和上下方向，则可以先把左右和上下两个方向的天际线求出来，然后再遍历增加，增加的时候是两个方向上对应天际线的更小的值。

**参考代码：**

```java
/**
* 原理：可以增加到左右和上下方向的天际线的最小值
*
* @param grid 原数组
* @return 最大增加的城市高度
*/
public int maxIncreaseKeepingSkyline(int[][] grid) {
    int row = grid.length;
    if (row == 0) {
        return 0;
    }
    int col = grid[0].length;
    // 左右方向的天际线
    int[] horizontal = new int[col];
    // 上下方向的天际线
    int[] vertical = new int[row];
    // 原数组元素和
    int oldSum = getSum(grid);
    // 获取两个方向的天际线
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            horizontal[i] = Math.max(horizontal[i], grid[i][j]);
            vertical[i] = Math.max(vertical[i], grid[j][i]);
        }
    }
    // 将各元素增加到左右和上下方向的天际线的最小值
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            grid[i][j] = Math.min(horizontal[i], vertical[j]);
        }
    }
    return getSum(grid) - oldSum;
}

/**
     * 获取元素和
     *
     * @param grid 数组
     * @return 和
     */
public int getSum(int[][] grid) {
    int sum = 0;
    for (int[] i : grid) {
        for (int j : i) {
            sum += j;
        }
    }
    return sum;
}
```


$$
\begin{cases} 时间复杂度：O(n^2)，需要遍历二维数组 \\\\空间复杂度： O(m)，新开辟了两个一维数组，m 为将原数组看作长方形的较长的边长\end{cases}
$$
