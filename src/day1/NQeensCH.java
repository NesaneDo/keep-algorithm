package day1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * 难度：困难
 * 
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例：
 * 
 * 输入：4
 * 
 * 输出：[ [".Q..", "...Q", "Q...", "..Q."],// 解法 1
 * 
 * ["..Q.", "Q...", "...Q", ".Q.."] ] // 解法 2
 * 
 * 解释: 4 皇后问题存在两个不同的解法。  
 * 
 * 提示：
 * 
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Rondo rondo_eleven@163.com
 * @version
 * @date 2020年9月6日 下午6:43:45
 */
public class NQeensCH {
	public static void main(String[] args) {
		NQeensCH nQeens = new NQeensCH();
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
