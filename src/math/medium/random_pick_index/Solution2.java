package math.medium.random_pick_index;

import java.util.Random;

/**
 * LeetCode 398. Random Pick Index
 * 水塘采样算法
 * @author Rondo Chan
 * @desc LeetCode 398. Random Pick Index
 * @since 2022/4/25
 * @version 1.0.0
 */
public class Solution2 {
    int[] nums;
    Random random;

    public Solution2(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int ans = 0;
        for (int i = 0, cnt = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                ans = random.nextInt(++cnt) == 0 ? i : ans;
            }
        }
        return ans;
    }
}
