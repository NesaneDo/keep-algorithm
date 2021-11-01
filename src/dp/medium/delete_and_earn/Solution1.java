package dp.medium.delete_and_earn;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态规划
 * @author Rondo Chan
 * @desc 动态规划
 * @since 2021/8/10
 * @version 1.0.0
 */
public class Solution1 {
    public int deleteAndEarn(int[] nums) {
        int len=nums.length;
        if(len==1){
            return nums[0];
        }
        int maxVal=0;
        for (int item:nums){
            if (item>maxVal){
                maxVal=item;
            }
        }
        int[] arr = new int[maxVal + 1];
        for (int item:nums){
            arr[item]+=item;
        }
        int pre=arr[0],max=Math.max(pre,arr[1]),temp;
        for (int i=2;i<arr.length;i++){
            temp=max;
            max=Math.max(pre+arr[i],max);
            pre=temp;
        }
        return max;
    }
    @Test
    public void test(){
        System.out.println(deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
}
