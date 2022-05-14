package string.medium.one_away_lcci;

/**
 * LeetCode 面试题 01.05 一次编辑
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 面试题 01.05 一次编辑
 * @since 2022/5/13
 */
public class Solutions {
    /**
     * 双指针，从两头记录相同的字符数，不相同时停止
     * 时间复杂度：O(n)，n 为 first 和 second 长度更小的值
     * 空间复杂度：O(1)
     */
    public boolean oneEditAway(String first, String second) {
        int fn = first.length() - 1, sn = second.length() - 1;
        if (Math.abs(fn - sn) > 1) {
            return false;
        }
        int i = 0, j = 0, same = 0;
        while (i <= fn && j <= sn && first.charAt(i++) == second.charAt(j++)) {
            same++;
        }
        while (fn >= 0 && sn >= 0 && first.charAt(fn--) == second.charAt(sn--)) {
            same++;
        }
        return first.length() - same < 2 && second.length() - same < 2;
    }
}
