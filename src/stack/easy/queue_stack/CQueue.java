package stack.easy.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * @author Rondo Chan
 * @desc 剑指 Offer 09. 用两个栈实现队列
 * @since 2021/6/18
 * @version 1.0.0
 */
public class CQueue {
    Deque<Integer> stack=new ArrayDeque<>();
    Deque<Integer> temp=new ArrayDeque<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        // 弹出栈为空则把添加栈的元素全部倒腾过来
        if(temp.isEmpty()){
            while(!stack.isEmpty()){
                temp.push(stack.pop());
            }
        }
        return temp.isEmpty()?-1:temp.pop();
    }
}
