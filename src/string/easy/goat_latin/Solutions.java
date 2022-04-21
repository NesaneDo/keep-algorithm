package string.easy.goat_latin;

/**
 * LeetCode 824.山羊拉丁文
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 824.山羊拉丁文
 * @since 2022/4/21
 */
public class Solutions {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        String p = "aeiouAEIOU";
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (p.indexOf(w.charAt(0)) != -1) {
                ans.append(w);
            } else {
                ans.append(w.substring(1, w.length())).append(w.charAt(0));
            }
            ans.append("ma");
            for (int j = 0; j <= i; j++) {
                ans.append("a");
            }
            ans.append(" ");
        }
        return ans.delete(ans.length() - 1, ans.length()).toString();
    }
}
