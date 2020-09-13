package day7;

public class WordSearchCH {
	public static void main(String[] args) {
		char[][] board = {

				{ 'A', 'B', 'C', 'E' },

				{ 'S', 'F', 'C', 'S' },

				{ 'A', 'D', 'E', 'E' } };

		String word = "ADECCE";
		WordSearchCH wordSearchCH=new WordSearchCH();
		System.out.println(wordSearchCH.exist(board, word));

	}

	private int m, n; // 二维数组的长宽
	private int[][] direction = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } }; // 偏移量数组
	private boolean[][] marked;
	private String word;
	private char[][] board;

	public boolean exist(char[][] board, String word) {
		this.word = word;
		this.board = board;
		m = board.length;
		if (m == 0) {
			return false;
		}
		n = board[0].length;
		marked = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(int i, int j, int start) {
		if (start == word.length() - 1) { // 通过判断最后一个字母的合法性，从而确定返回值
			return board[i][j] == word.charAt(start);
		}
		if (board[i][j] == word.charAt(start)) {
			marked[i][j] = true;
			for (int k = 0; k < 4; k++) { // 尝试 4 个方向
				int sx = i + direction[k][0];
				int sy = j + direction[k][1];
				if (inBoard(sx, sy) && !marked[sx][sy]) {
					if (dfs(sx, sy, start + 1)) {
						return true;
					}
				}
			}
			marked[i][j] = false;
		}
		return false;
	}

	/**
	 * 是否越界
	 * 
	 * @author Rondo
	 * @date 2020年9月13日 下午4:39:22
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean inBoard(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}
}
