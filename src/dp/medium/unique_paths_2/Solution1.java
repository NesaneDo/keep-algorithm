package dp.medium.unique_paths_2;
/**
 * 动态规划：与不同路径I 类似，只需简单处理下障碍物的地方
 * @author Rondo Chan
 * @desc 动态规划：与不同路径I 类似，只需简单处理下障碍物的地方
 * @since 2021/11/2
 * @version 1.0.0
 */
public class Solution1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int [][] dp=new int[m][n];
        // 初始化首列
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==1){
                break;
            }
            dp[i][0]=1;
        }
        // 初始化首行，本来可以从1开始，但是 obstacleGrid[0][0]=1 emmmmm...
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==1){
                break;
            }
            dp[0][i]=1;
        }
        // 将 obstacleGrid 的值反转一下，0 <-> 1
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=(dp[i-1][j]+dp[i][j-1])*(obstacleGrid[i][j]^1);
            }
        }
        return dp[m-1][n-1];
    }
}
