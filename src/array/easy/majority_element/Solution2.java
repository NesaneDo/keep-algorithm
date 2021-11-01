package array.easy.majority_element;

/**
 * Boyer-Moore投票算法
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc Boyer-Moore投票算法
 * @since 2021/9/13
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        int candidate = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += candidate == nums[i] ? 1 : -1;
        }
        return candidate;
    }
}
