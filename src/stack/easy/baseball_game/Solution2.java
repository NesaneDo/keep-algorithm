package stack.baseball_game;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Rondo Chan
 * @version 1.0.0
 * @description 使用栈
 * @since 2021/4/19 10:16
 */
public class Solution2 {
    public int calPoints(String[] ops){
        Deque<Integer> stack = new LinkedList<>();
        int sum=0;
        for (String n:ops){
            // 判断操作符和数字
            switch (n){
                case "+":
                    // 这里需要弹出一个，然后又把它装回去
                    int peek1=stack.pop();
                    int afterPeek=stack.peek();
                    stack.push(peek1);
                    stack.push(peek1+afterPeek);
                    sum+=stack.peek();
                    break;
                case "C":
                    sum-=stack.pop();
                    break;
                case "D":
                    int numd=stack.peek()*2;
                    stack.push(numd);
                    sum+=numd;
                    break;
                default:
                    int num=Integer.parseInt(n);
                    stack.push(num);
                    sum+=num;
                    break;
            }
        }
        return sum;
    }
    @Test
    public void test() {
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
        System.out.println();
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println();
        System.out.println(calPoints(new String[]{"-60", "D", "-36", "30", "13", "C", "C", "-33", "53", "79"}));
    }
}
