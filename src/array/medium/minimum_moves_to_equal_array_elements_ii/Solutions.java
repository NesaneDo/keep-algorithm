package array.medium.minimum_moves_to_equal_array_elements_ii;

import java.util.Arrays;
import java.util.Random;

/**
 * LeetCode 462. Minimum Moves to Equal Array Elements II
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 462. Minimum Moves to Equal Array Elements II
 * @since 2022/5/19
 */
public class Solutions {
    /**
     * 此题需要用到中位数，再求各元素与中位数差值的和即可。<br>
     * 为什么是中位数而不是平均数？首先答案一定在数组的最小值 min 与最大值之间 max。假设答案在 (min, max) 之外，则数组的中位数的移动次数会占一部分，
     * 而在 (min, max) 之内，至少 中位数的移动次数会更低，直到选择的数是 中位数时，中位数占的移动次数为 0
     */
    public int minMoves2(int[] nums) {
        int n = nums.length, ans = 0;
        Arrays.sort(nums);
        for (int i : nums) {
            ans += Math.abs(i - nums[n / 2]);
        }
        return ans;
    }

    /**
     * 官方题解，以本人现在的功力还无法理解 $.$<br>
     * <code>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/solution/zui-shao-yi-dong-ci-shu-shi-shu-zu-yuan-xt3r2/
     * 来源：力扣（LeetCode）
     * </code>
     */
    Random random = new Random();

    public int minMoves21(int[] nums) {
        int n = nums.length, x = quickSelect(nums, 0, n - 1, n / 2), ret = 0;
        for (int i = 0; i < n; ++i) {
            ret += Math.abs(nums[i] - x);
        }
        return ret;
    }

    public int quickSelect(int[] nums, int left, int right, int index) {
        int q = randomPartition(nums, left, right);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
        }
    }

    public int randomPartition(int[] nums, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(nums, i, right);
        return partition(nums, left, right);
    }

    public int partition(int[] nums, int left, int right) {
        int x = nums[right], i = left - 1;
        for (int j = left; j < right; ++j) {
            if (nums[j] <= x) {
                ++i;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        if (nums[i] != nums[j]) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}
