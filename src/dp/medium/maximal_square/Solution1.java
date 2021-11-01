package dp.medium.maximal_square;

/**
 * 使用动态规划
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc 使用动态规划
 * @since 2021/11/1
 */
public class Solution1 {
    public int maximalSquare(char[][] matrix) {
        if(null==matrix||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int row=matrix.length,col=matrix[0].length;
        int [][] dp=new int[row][col];
        // 保存当前最大边长
        int max=0;
        // 初始化首行和首列
        for(int i=0;i<row;i++){
            if(matrix[i][0]=='1'){
                max=1;
                dp[i][0]=1;
            }
        }
        for(int i=1;i<col;i++){
            if(matrix[0][i]=='1'){
                max=1;
                dp[0][i]=1;
            }
        }

        // dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
