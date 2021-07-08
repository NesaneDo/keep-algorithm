package dp.easy.climbing_stairs;

import org.junit.Test;

/**
 * @author Rondo Chan
 * @version 1.0.0
 * @desc
 * @since 2021/7/1
 */
public class Solution1 {
    public int climbStairs2(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int t1 = 1,t2=2;
        int res=t1+t2;
        for (int i = 3; i <= n; i++) {
            res=t1+t2;
            t1=t2;
            t2=res;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
    }
}
