package stack.easy.make_the_string_great;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * 使用栈
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc 使用栈
 * @since 2021/6/17
 */
public class Solution1 {
    public String makeGood(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()&&(stack.peek() == c + 32 || stack.peek() == c - 32)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        Iterator<Character> characterIterator = stack.descendingIterator();
        while (characterIterator.hasNext()){
            res.append(characterIterator.next());
        }
        return res.toString();
    }
    @Test
    public void test(){
        System.out.println(makeGood("leEeetcode"));
    }
}
