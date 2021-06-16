package stack.queue_stack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Rondo Chan
 * @version 1.0.0
 * @description
 * @since 2021/4/16 16:33
 */
public class MyQueue {
    private Deque<Integer> data, temp;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        data = new LinkedList<>();
        temp = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        // 先把 data 中数据全部入栈到 temp
        while (!data.isEmpty()) {
            temp.push(data.pop());
        }
        // 再入栈到 temp
        temp.push(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        // 取的时候用 data 翻转 temp 中的数据
        while (!temp.isEmpty()) {
            data.push(temp.pop());
        }

        return data.pop();
    }

    /**
     * Get the top element.
     */
    public int peek() {
        while (!temp.isEmpty()) {
            data.push(temp.pop());
        }
        return data.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return data.isEmpty() && temp.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.pop());
        myQueue.push(5);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

}
