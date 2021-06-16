package stack.easy.min_stack;

/**
 * 自己设计栈：最后要么超内存，要么超时间 [苦涩]
 * 
 * @author Rondo rondo_eleven@163.com
 * @version
 * @date 2021年4月9日 下午3:27:26
 */
public class MinStack {

	/**
	 * 初始容量 16，后面可能会涉及到扩容
	 */
	private int capacity = 16;
	/**
	 * 扩容因子
	 */
	private static final int RESIZE_FACTOR = 2;
	/**
	 * 保存的元素
	 */
	private int[][] elements = new int[capacity][2];
	/**
	 * 栈顶指针
	 */
	private int top = -1;
	/**
	 * 保存最小值元素
	 */
	private int minVal = Integer.MAX_VALUE;

	public MinStack() {

	}

	public void push(int val) {
		// 压栈指针要加 1
		top++;
		// 如果栈为空，则
		if (top == 0) {
			elements[top] = new int[] { val, val };
			// 如果栈未满
		} else if (elements.length < capacity) {
			save(val);
			// 如果栈满了就要扩容
		} else {
			resize();
			save(val);
		}
		System.out.print("push: ");
		System.out.print(elements[top][0] + " , ");
		System.out.println(elements[top][1]);
	}

	/**
	 * 保存元素
	 * 
	 * @author Rondo
	 * @date 2021年4月9日 下午4:54:04
	 * @param val
	 */
	private void save(int val) {
		// 保存更小的一个值
		minVal = elements[top - 1][1] <= val ? elements[top - 1][1] : val;
		elements[top] = new int[] { val, minVal };
	}

	/**
	 * 扩容
	 * 
	 * @author Rondo
	 * @date 2021年4月9日 下午4:49:13
	 */
	private void resize() {
		// 扩 RESIZE_FACTOR 倍数
		capacity *= RESIZE_FACTOR;
		int[][] temp = new int[capacity][2];
		for (int i = 0; i < elements.length; i++) {
			temp[i] = elements[i];
		}
		elements = temp;
	}

	public void pop() {
		// 最后一个元素，需要把最小值重置
		if (top == 0) {
			minVal = Integer.MAX_VALUE;
		}
		if (top > -1) {
			System.out.print("pop: ");
			System.out.print(elements[top][0] + " ,");
			System.out.println(elements[top][1]);
			top--;
		} else {
			throw new RuntimeException("The stack was empty");
		}
	}

	public int top() {
		if (top < 0) {
			throw new RuntimeException("The stack was empty");
		}
		return elements[top][0];
	}

	public int getMin() {
		if (top < 0) {
			throw new RuntimeException("The stack was empty");
		}
		return elements[top][1];
	}
}
