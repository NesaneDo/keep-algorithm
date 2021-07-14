package array.easy.squares_of_a_sorted_array;

/**
 * 双指针
 * @author Rondo Chan
 * @desc 双指针
 * @since 2021/7/14
 * @version 1.0.0
 */
public class Solution1 {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0, j = len - 1, k = len - 1; i <= j; ) {
            int i2 = nums[i] * nums[i];
            int j2 = nums[j] * nums[j];
            if (i2 > j2) {
                res[k--] = i2;
                i++;
            } else {
                res[k--] = j2;
                j--;
            }
        }
        return res;
    }
}
