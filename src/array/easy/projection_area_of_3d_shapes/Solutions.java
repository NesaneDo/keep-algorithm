package array.easy.projection_area_of_3d_shapes;

/**
 * LeetCode 883. 三维形体投影面积
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 883. 三维形体投影面积
 * @since 2022/4/26
 */
public class Solutions {
    public int projectionArea(int[][] grid) {
        int area = 0;
        int[] rowMax = new int[grid[0].length], colMax = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 俯视面积
                area += grid[i][j] == 0 ? 0 : 1;
                rowMax[j] = Math.max(rowMax[j], grid[i][j]);
                colMax[i] = Math.max(colMax[i], grid[i][j]);
            }
        }
        // return area+Arrays.stream(rowMax).sum()+Arrays.stream(colMax).sum();
        for (int i = 0; i < colMax.length; i++) {
            area += colMax[i] + rowMax[i];
        }
        return area;
    }
}
