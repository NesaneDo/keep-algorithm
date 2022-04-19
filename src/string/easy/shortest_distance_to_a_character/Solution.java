package string.easy.shortest_distance_to_a_character;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 821. 字符的最短距离
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 821. 字符的最短距离
 * @since 2022/4/19
 */
public class Solution {
    /**
     * 分段处理
     */
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] ans = new int[len];
        List<Integer> cLocs = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                cLocs.add(i);
            }
        }
        // cLocs 的长度一定 >= 1
        // 第一段
        for (int i = 0; i < cLocs.get(0); i++) {
            ans[i] = cLocs.get(0) - i;
        }
        // 最后一段
        for (int i = len - 1; i >= cLocs.get(cLocs.size() - 1); i--) {
            ans[i] = i - cLocs.get(cLocs.size() - 1);
        }
        int start, end, avg;
        // 中间几段
        for (int i = 0; i < cLocs.size() - 1; i++) {
            start = cLocs.get(i) + 1;
            end = cLocs.get(i + 1);
            avg = (start + end) / 2;
            for (int n = 0; n < avg - start; n++) {
                ans[start + n] = n + 1;
            }
            for (int n = 0; n < end - avg; n++) {
                ans[avg + n] = end - avg - n;
            }
        }
        return ans;
    }
}
