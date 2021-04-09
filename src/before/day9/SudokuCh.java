package before.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuCh {

	public static void main(String[] args) {

		char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
				SudokuCh sudokuCh=new SudokuCh();
				sudokuCh.solveSudoku(board);
				for (int i = 0; i < board.length; i++) {
					System.out.println(Arrays.toString(board[i]));
				}
	}

	private boolean[][] line = new boolean[9][9];
	private boolean[][] column = new boolean[9][9];
	private boolean[][][] block = new boolean[3][3][9];
	private boolean valid = false;
	private List<int[]> spaces = new ArrayList<int[]>();

	public void solveSudoku(char[][] board) {
		// 遍历数组，找到已存在的数字
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.') {
					spaces.add(new int[] { i, j });
				} else {
					int d = board[i][j] - '0' - 1; // board[i][j]='5'; ===> d=4 转为数字
					line[i][d] = column[j][d] = block[i / 3][j / 3][d] = true;
				}
			}
		}
		dfs(board, 0);
	}

	private void dfs(char[][] board, int pos) {
		if (pos == spaces.size()) {
			valid = true;
			return;
		}
		int[] space = spaces.get(pos);
		int i = space[0], j = space[1];
		for (int d = 0; d < 9 && !valid; ++d) {
			if (!line[i][d] && !column[j][d] && !block[i / 3][j / 3][d]) {
				line[i][d] = column[j][d] = block[i / 3][j / 3][d] = true;
				board[i][j] = (char) (d + '0' + 1);
				dfs(board, pos + 1);
				line[i][d] = column[j][d] = block[i / 3][j / 3][d] = false;
			}
		}
	}
}
