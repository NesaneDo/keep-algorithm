> 解法一：动态规划

本题与 LeetCode 62.不同路径 类似，只需处理下障碍物的地方即可，将有障碍物的地方设置为0，其余一样

> **参考代码：**
>
> ```java
> public int uniquePathsWithObstacles(int[][] obstacleGrid) {
>     int m=obstacleGrid.length,n=obstacleGrid[0].length;
>     int [][] dp=new int[m][n];
>     // 初始化首列
>     for(int i=0;i<m;i++){
>         if(obstacleGrid[i][0]==1){
>             break;
>         }
>         dp[i][0]=1;
>     }
>     // 初始化首行，本来可以从1开始，但是 obstacleGrid[0][0]=1 emmmmm...
>     for(int i=0;i<n;i++){
>         if(obstacleGrid[0][i]==1){
>             break;
>         }
>         dp[0][i]=1;
>     }
>     // 将 obstacleGrid 的值反转一下，0 <-> 1
>     for(int i=1;i<m;i++){
>         for(int j=1;j<n;j++){
>             dp[i][j]=(dp[i-1][j]+dp[i][j-1])*(obstacleGrid[i][j]^1);
>         }
>     }
>     return dp[m-1][n-1];
> }
> ```
>
> 