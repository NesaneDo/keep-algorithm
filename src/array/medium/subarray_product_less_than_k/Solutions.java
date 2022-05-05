package array.medium.subarray_product_less_than_k;

/**
 * LeetCode 713. 乘积小于 k 的子数组
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 713. 乘积小于
 * @since 2022/5/5
 */
public class Solutions {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2) return 0;
        int res = 0;
        for (int i = 0, j = 0, product = 1; i < nums.length; i++) {
            product *= nums[i];
            while (product >= k) {
                product /= nums[j++];
            }
            res += i - j + 1;
        }
        return res;
    }
}
