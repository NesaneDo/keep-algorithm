package array.easy.majority_element;

import java.util.Arrays;

/**
 * 排序
 * @author Rondo Chan
 * @desc
 * @since 2021/9/13
 * @version 1.0.0
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
