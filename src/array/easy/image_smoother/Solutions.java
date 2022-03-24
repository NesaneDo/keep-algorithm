package array.easy.image_smoother;

import java.util.Arrays;

/**
 * LeetCode 661. 图片平滑器
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 661. 图片平滑器
 * @since 2022/3/24
 */
public class Solutions {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        // 只有一个格子的情况
        if (m * n == 1) {
            return img;
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = avg(m, n, img, i, j);
            }
        }
        return res;
    }

    int avg(int m, int n, int[][] img, int i, int j) {
        int count = 1;
        int[][] bds=new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int sum=img[i][j];
        for(int[] bd:bds){
            int x=i+bd[0],y=j+bd[1];
            if (x>=0&&x<m&&y>=0&&y<n){
                sum+=img[x][y];
                count++;
            }
        }
        return (int)Math.floor((double)sum/count);
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(new Solutions().imageSmoother(new int[][]{{1,1,1}})));
        System.out.println(Arrays.deepToString(new Solutions().imageSmoother(new int[][]{{100,200,100},{200,50,200},{100,200,100}})));
    }
}
