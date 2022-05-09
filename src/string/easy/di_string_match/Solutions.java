package string.easy.di_string_match;

/**
 * LeetCode 942. Di String Match
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 942. DI String Match
 * @since 2022/5/9
 */
public class Solutions {
    public int[] diStringMatch(String s) {
        int n = s.length(), st = 0, e = n, i = 0;
        int[] res = new int[n + 1];
        for (char c : s.toCharArray()) {
            res[i++] = c == 'I' ? st++ : e--;
        }
        // array length is 1 greater than string's
        res[i] = st;
        return res;
    }
}
