package array.easy.maximum_subarray;

import org.junit.Test;

public class Solution3 {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for (int n:nums){
            if (sum<0){
                sum=n;
            }else{
                sum+=n;
            }
            max=Math.max(max,sum);
        }
        return max;
    }

    @Test
    public void t() {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{-2}));
    }
}
