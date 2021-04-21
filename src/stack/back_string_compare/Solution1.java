package stack.back_string_compare;

import org.junit.Test;

/**
 * @author Rondo Chan
 * @version 1.0.0
 * @description 保存退格后的字符串再比较
 * @since 2021/4/21 14:24
 */
public class Solution1 {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder src = new StringBuilder();
        StringBuilder target = new StringBuilder();
        getBackString(s, src);
        getBackString(t, target);
        return src.toString().equals(target.toString());
    }

    private void getBackString(String t, StringBuilder target) {
        for (char c : t.toCharArray()) {
            int len = target.length();
            if (c == '#') {
                if (len > 0) {
                    target.deleteCharAt(len - 1);
                }
            } else {
                target.append(c);
            }
        }
    }

    @Test
    public void test() {
        System.out.println(backspaceCompare("y#fo##f"
                , "y#f#o##f"));
    }
}
