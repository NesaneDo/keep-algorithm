package before.day1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 搜索问题一般来说复杂度很高，因此在线测评系统的后台测试数据不会很大。因此布尔数组可以只用一个整数来代替（int 或者 long 根据情况决定），int
 * 类型整数等价于一个 32 位布尔数组，long 类型整数等价于一个 64 位布尔数组。
 * 
 * 使用一个整数代表一个布尔数组，在比较布尔数组所有的位的值是否相等时，只需要 O(1)O(1)，并且传递参数、复制也是相对方便的。这样的技巧叫做「状态压缩」
 * 
 * 作者：liweiwei1419
 * 链接：https://leetcode-cn.com/problems/n-queens/solution/gen-ju-di-46-ti-quan-pai-lie-de-hui-su-suan-fa-si-/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 * @author Rondo rondo_eleven@163.com
 * @version
 * @date 2020年9月6日 下午6:25:46
 */
public class NQeensAnswer {
	public static void main(String[] args) {
		NQeensAnswer answer = new NQeensAnswer();
		List<List<String>> list = answer.solveNQueens(5);
		;
		System.out.println(list);
	}

	private List<List<String>> res;
	private int n;

	public List<List<String>> solveNQueens(int n) {
		this.n = n;
		res = new ArrayList<>();
		if (n == 0) {
			return res;
		}

		int col = 0;
		int main = 0;
		int sub = 0;
		Deque<Integer> path = new ArrayDeque<>();

		dfs(0, col, main, sub, path);
		return res;
	}

	private void dfs(int row, int col, int sub, int main, Deque<Integer> path) {
		if (row == n) {
			List<String> board = convert2board(path);
			res.add(board);
			return;
		}

		// 针对每一列，尝试是否可以放置
		for (int i = 0; i < n; i++) {
			if (((col >> i) & 1) == 0 && ((sub >> (row + i)) & 1) == 0 && ((main >> (row - i + n - 1)) & 1) == 0) {
				path.addLast(i);
				col ^= (1 << i);
				sub ^= (1 << (row + i));
				main ^= (1 << (row - i + n - 1));

				dfs(row + 1, col, sub, main, path);

				main ^= (1 << (row - i + n - 1));
				sub ^= (1 << (row + i));
				col ^= (1 << i);
				path.removeLast();
			}
		}
	}

	private List<String> convert2board(Deque<Integer> path) {
		List<String> board = new ArrayList<>();
		for (Integer num : path) {
			StringBuilder row = new StringBuilder();
//			row.append(".".repeat(Math.max(0, n)));
			row.replace(num, num + 1, "Q");
			board.add(row.toString());
		}
		return board;
	}
}
