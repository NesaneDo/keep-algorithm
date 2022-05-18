package math.hard.kth_smallest_number_in_multiplication_table;

import org.junit.Test;

import java.util.Arrays;

/**
 * LeetCode 668. Kth Smallest Number in Multiplication Table
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc
 * @since 2022/5/18
 */
public class Solutions {
    /**
     * 暴力解法，用于数组先保存所有数，排序后再使用 k 下标的值返回
     * <br>
     * 时间复杂度：O(m*n)<br>
     * 空间复杂度：O(m*n)
     */
    public int findKthNumber1(int m, int n, int k) {
        int[] nums = new int[m * n];
        int t = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                nums[t++] = i * j;
            }
        }
        Arrays.sort(nums);
        return nums[k];
    }

    /**
     * 二分查找
     */
    public int findKthNumber2(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; ++i) {
                count += x / i;
            }
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }
}
