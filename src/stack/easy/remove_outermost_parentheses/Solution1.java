package stack.easy.remove_outermost_parentheses;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 方法一：使用栈
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc 方法一：使用栈
 * @since 2021/6/16
 */
public class Solution1 {
    public String removeOuterParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
            }
            if (stack.size() > 0) {
                res.append(c);
            }
        }
        return res.toString();
    }

    @Test
    public void main() {
        System.out.println(removeOuterParentheses("(()())(())"));
    }
}
