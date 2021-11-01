> 解法一：动态规划

**常识：**正方形的面积大小取决于边长的大小。

使用一个数组 `dp` 来保存各数据对应的边长大小，而 `dp[i][j]` 由 `dp[i-1][j],dp[j][i-1]和dp[i-1][j-1]` 的最小值再加上 `1` 决定，当遇到`maxtrix[i][j]==0`时，`dp[i][j]=0`，即 `dp[i][j]=min(dp[i-1][j],dp[j][i-1]和dp[i][j])+1` 比如下方数据 `matrix`

|  0   |  1   |  0   |  1   |
| :--: | :--: | :--: | :--: |
|  1   |  1   |  1   |  0   |
|  1   |  1   |  1   |  1   |
|  1   |  1   |  1   |  1   |
|  0   |  1   |  0   |  1   |

生成的对应的 `dp`

|  0   |  1   |  0   |  1   |
| :--: | :--: | :--: | :--: |
|  1   |  1   |  1   |  0   |
|  1   |  2   |  2   |  1   |
|  1   |  2   |  3   |  2   |
|  0   |  1   |  0   |  1   |

综上，状态转移方程为：
$$
\begin{cases} dp[i][j]=0,\quad (matrix[i][j]=0)\\\\dp[i][j]=matrix[i][j],\quad (i=0或者j=0)\\\\ dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1,\quad (i>0,j>0,matrix[i][j]=1)\end{cases}
$$


> **参考代码：**

```java
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
```

