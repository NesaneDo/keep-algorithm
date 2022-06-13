package array.easy.height_checker;

import java.util.Arrays;

/**
 * LeetCode 1051.Height Checker
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 1051.Height Checker
 * @since 2022/6/13
 */
public class Solutions {
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
}
