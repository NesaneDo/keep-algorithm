package array.easy.maximum_subarray;

import org.junit.Test;

import java.util.Map;

/**
 * 动态规划
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc 动态规划
 * @since 2021/6/30
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        // 题目已经规定 nums.length>=1
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(dp, max);
        }
        return max;
    }

    @Test
    public void t() {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
