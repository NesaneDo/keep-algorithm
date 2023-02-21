package array.easy.maximize_sum_of_array_after_k_negations;

import java.util.Arrays;

/**
 * 排序
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc 排序
 * @since 2021/12/3
 */
public class Solutions {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 排序
        Arrays.sort(nums);
        // 记录最小绝对值，因为题目说最大为100，所以初始化为100
        int minN = 100;
        int sum = 0;
        for (int i : nums) {
            if (k > 0 && i < 0) {
                i = -i;
                k--;
            }
            minN = Math.min(i, minN);
            sum += i;
        }
        // 若负数反转完后 k>0, 则判断k的奇偶性，偶数反转两次则抵消，奇数则需要减去2倍的minN
        return sum - ((k > 0 && (k & 1) != 0) ? 2 * minN : 0);
    }
}
