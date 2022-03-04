package string.medium.count_and_say;

/**
 * LeetCode 38. 外观数列
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 38. 外观数列
 * @since 2021/12/14
 */
public class Solutions {
    public String countAndSay(int n) {
        String res = "1";
        if (n == 1) {
            return res;
        }
        for (int i = 1; i < n; i++) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            int len = res.length();
            for (int j = 0; j < len; j++) {
                char c1 = res.charAt(j);
                char c2 = ' ';
                if (j + 1 < len) {
                    c2 = res.charAt(j + 1);
                }
                if (c1 == c2) {
                    count++;
                } else {
                    sb.append(count).append(c1);
                    count=1;
                }
            }
            res = sb.toString();
        }
        return res;
    }
}
