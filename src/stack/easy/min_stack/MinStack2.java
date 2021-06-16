package stack.easy.min_stack;

import java.util.Stack;

/**
 * 使用 Stack 类
 * 
 * @author Rondo rondo_eleven@163.com
 * @version
 * @date 2021年4月9日 下午5:50:00
 */
public class MinStack2 {
	private Stack<Integer[]> stack = new Stack<Integer[]>();

	public MinStack2() {

	}

	public void push(int val) {
		if (stack.isEmpty()) {
			stack.push(new Integer[] { val, val });
		} else {
			stack.push(new Integer[] { val, stack.peek()[1] < val ? stack.peek()[1] : val });
		}
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek()[0];
	}

	public int getMin() {
		if (!stack.isEmpty()) {
			return stack.peek()[1];
		}
		throw new RuntimeException("The stack was empty");
	}
}
