package dp.medium.unique_paths;

/**
 * 动态规划，首行和首列都只有一条路径，所有先初始化为1，
 * 然后找到状态转移方程，dp[i][j]=dp[i-1][j]+dp[i][j-1]，
 * 也就是从上方来的和从左方来的两种
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc 动态规划，首行和首列都只有一条路径，所有先初始化为1
 * @since 2021/11/2
 */
public class Solution1 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
