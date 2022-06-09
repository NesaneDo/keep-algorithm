package array.medium.random_point_in_non_overlapping_rectangles;

import java.util.Random;

/**
 * LeetCode 497. Random Point in Non-overlapping Rectangles
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 497. Random Point in Non-overlapping Rectangles
 * @since 2022/6/9
 */
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
