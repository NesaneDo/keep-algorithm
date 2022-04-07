package string.easy.rotate_string;

/**
 * LeetCode 796. 旋转字符串
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 796. 旋转字符串
 * @since 2022/4/7
 */
public class Solutions {
    /**
     * 解法一：
     * 使用 StringBuilder 挨个变换
     */
    public boolean rotateString1(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            sb.insert(0, sb.charAt(sb.length() - 1)).deleteCharAt(sb.length() - 1);
            if (sb.toString().equals(goal)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解法二：
     * 任意变换若干次后，goal 一定会出现在 s+s 中
     */
    public boolean rotateString2(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

}
