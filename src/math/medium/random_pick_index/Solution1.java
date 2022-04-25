package math.medium.random_pick_index;

import java.util.*;

/**
 * LeetCode 398. Random Pick Index
 * 使用 哈希表 保存唯一元素的所有下标，取时再随机取即可
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 398. Random Pick Index
 * @since 2022/4/25
 */
public class Solution1 {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Random rd = new Random();

    public Solution1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new LinkedList<>());
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> l = map.get(target);
        return l.get(rd.nextInt(l.size()));
    }
}
