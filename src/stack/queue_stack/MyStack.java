package stack.queue_stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Rondo rondo_eleven@163.com
 * @version
 * @date 2021年4月9日 下午5:55:25
 */
public class MyStack {
	Queue<Integer> data, temp;

	/** Initialize your data structure here. */
	public MyStack() {
		data = new LinkedList<Integer>();
		temp = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		// 先入队到 temp
		temp.offer(x);
		// 将 data 中的数据依次出队到 temp 中
		while(!data.isEmpty()) {
			temp.offer(data.poll());
		}
		// 交换队列
		Queue<Integer> t=data;
		data=temp;
		temp=t;
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return data.poll();
	}

	/** Get the top element. */
	public int top() {
		return data.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return data.isEmpty();
	}
}
