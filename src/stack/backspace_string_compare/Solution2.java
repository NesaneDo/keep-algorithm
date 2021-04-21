package stack.backspace_string_compare;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Rondo Chan
 * @version 1.0.0
 * @description 使用栈
 * @since 2021/4/21 14:40
 */
public class Solution2 {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> src = new LinkedList<>();
        Deque<Character> target = new LinkedList<>();
        getBackStack(s, src);
        getBackStack(t, target);
        if (src.size() != target.size()) {
            return false;
        }
        while (!src.isEmpty()) {
            if (!src.pop().equals(target.pop())) {
                return false;
            }
        }
        return true;
    }

    private void getBackStack(String t, Deque<Character> target) {
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (!target.isEmpty()) {
                    target.pop();
                }
            } else {
                target.push(c);
            }
        }
    }
    @Test
    public void test() {
        System.out.println(backspaceCompare("y#fo##f"
                , "y#f#o##f"));
    }
}
