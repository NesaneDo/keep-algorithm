package array.easy.maximum_subarray;

import org.junit.Test;

/**
 * 暴力解法：双重循环
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @since 2021/6/30
 */
public class Solution1 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int t = 0;
            for (int j = i; j < nums.length; j++) {
                t += nums[j];
                if (t > max) {
                    max = t;
                }
            }
        }
        return max;
    }

}
