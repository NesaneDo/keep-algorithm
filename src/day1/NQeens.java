package day1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Level: Hard
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * Example:
 * 
 * Input: 4 Output: [ [".Q..", "...Q", "Q...", "..Q."], // Solution 1
 * 
 * ["..Q.", "Q...", "...Q", ".Q.."] ] // Solution 2
 * 
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as
 * shown above.
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Rondo rondo_eleven@163.com
 * @version
 * @date 2020年9月6日 下午6:46:30
 */
public class NQeens {
	public static void main(String[] args) {
		NQeens nQeens = new NQeens();
		List<List<String>> name = nQeens.solveNQueens(4);
		int i = 1;
		for (List<String> strList : name) {
			for (String s : strList) {
				for (char c : s.toCharArray()) {
					System.out.print(c + "\t");
				}
				System.out.println();
			}
			System.out.println(i++ + " ==========================================");
		}
	}

	// 用于记录上一个 Queen 的位置
	Deque<Integer[]> pos = new ArrayDeque<Integer[]>();
	List<List<String>> res = new ArrayList<List<String>>();

	// 深度优先搜索
	public List<List<String>> solveNQueens(int n) {
		if (n == 1) { // 唯一情况
			res.add(new ArrayList<String>() {
				private static final long serialVersionUID = 1L;

				{
					add("Q");
				}
			});
		}
		if (n < 4) { // 当 n >= 4 时才可能有解
			return res;
		}
		boolean[][] valid = new boolean[n][n]; // 标志可能的放置的位置
		for (int i = 0; i < valid.length; i++) {
			for (int j = 0; j < valid[i].length; j++) {
				valid[i][j] = true;
			}
		}
		dfs(valid, 0); // 从第一行开始
		return res;
	}

	/**
	 * 递归：深度优先搜索
	 * 
	 * @author Rondo
	 * @date 2020年9月6日 上午9:44:01
	 * @param row
	 * @param col
	 */
	public void dfs(boolean[][] validO, int row) {
		boolean[][] valid = new boolean[validO.length][validO.length]; // 每层维护一个二维数组
		for (int i = 0; i < validO.length; i++) { // 使用深拷贝
			for (int j = 0; j < validO[i].length; j++) {
				valid[i][j] = validO[i][j];
			}
		}
		//	boolean[][] valid=Arrays.copyOf(validO, validO.length); // 不是深拷贝，不能使用
		if (row >= valid.length) {
			convert2board(valid);
			return;
		}
		boolean has = false; // 标志当前行是否存在皇后
		for (int i = 0, col = i; i < valid[row].length; i++) {
			if (valid[row][i]) {
				pos.push(new Integer[] { row, i });
				has = true;
				col = i;
				setState(valid, row, i, false); // 将同行同列同斜线上的值设置为 false
				valid[row][i] = true; // 将放置的位置设为 true
				dfs(valid, row + 1);
			}
			// 以下代码是从下一层返回后执行
			if (has) { //
				setState(valid, row, col, true); // 恢复被使用前的可用状态
				pos.pop(); // 出栈首元素，因为上一步已经恢复了
				Iterator<Integer[]> iterator = pos.iterator(); // 恢复之前放置皇后的禁用状态
				while (iterator.hasNext()) {
					Integer[] x = iterator.next();
					setState(valid, x[0], x[1], false);
				}
				has = false;
			}
			if (!has && i == valid[row].length - 1) { // 当前行被遍历完成且没有放置皇后，则返回上一层
				valid[row][col] = true; // 返回上一层时将当前位置置为可用
				return;
			}
		}
	}

	/**
	 * 状态改变
	 * 
	 * @author Rondo
	 * @date 2020年9月6日 下午6:27:26
	 * @param valid
	 * @param row
	 * @param col
	 * @param state
	 */
	private void setState(boolean[][] valid, int row, int col, boolean state) {
		for (int r = row + 1, c = col + 1; r < valid.length && c < valid.length; r++, c++) {
			valid[r][c] = state;
		}
		for (int r = row + 1, c = col - 1; r < valid.length && c >= 0; r++, c--) {
			valid[r][c] = state;
		}
		for (int j = 0; j < valid.length; j++) {
			valid[row][j] = state;
		}
		for (int i = row + 1; i < valid.length; i++) {
			valid[i][col] = state;
		}
		valid[row][col] = !state;
	}

	/**
	 * 转化
	 * 
	 * @author Rondo
	 * @date 2020年9月3日 下午6:56:39
	 * @return
	 */
	private void convert2board(boolean[][] valid) {
		List<String> board = new ArrayList<>();
		for (int i = 0; i < valid.length; i++) {
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < valid[i].length; j++) {
				builder.append(valid[i][j] ? "Q" : ".");
			}
			board.add(builder.toString());
		}
		res.add(new ArrayList<String>(board));
	}
}
