package string.easy.reverse_words_in_a_string_III;
/**
 * 不使用 split 函数，根据空格的下标来对每个字符串进行反转
 * @author Rondo Chan
 * @desc 不使用 split 函数，根据空格的下标来对每个字符串进行反转
 * @since 2021/7/26
 * @version 1.0.0
 */

public class Solution1 {
    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return s;
        }
        s += " ";
        int is = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ') {
                // 将 /2 换成 >>1 直接从 6ms 降到 3ms，book11啊
                for (int j = is, k = 0; j < is + ((i - is) >> 1); j++, k++) {
                    char c = cs[j];
                    cs[j] = cs[i - k - 1];
                    cs[i - k - 1] = c;
                }
                is = i + 1;
            }
        }
        return new String(cs, 0, cs.length - 1);
    }
}
