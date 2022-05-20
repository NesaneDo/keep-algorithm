package array.medium.find_right_interval;

import java.util.Map;
import java.util.TreeMap;

/**
 * LeetCode 436. Find Right Interval
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 436. Find Right Interval
 * @since 2022/5/20
 */
public class Solutions {
    /**
     * 用 TreeMap 的特性，给 intervals[i][0] 排序，再利用内置的获取大于等于 intervals[i][1] 的最小的元素
     */
    public int[] findRightInterval(int[][] intervals) {
        int[] ans = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < ans.length; i++) {
            map.put(intervals[i][0], i);
        }
        for (int i = 0; i < ans.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            ans[i] = entry == null ? -1 : entry.getValue();
        }
        return ans;
    }
}
