package array.medium.max_increase_to_keep_city_skyline;

/**
 * 保持城市最大天际线
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc
 * @since 2021/12/13
 */
public class Solutions {
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
}
