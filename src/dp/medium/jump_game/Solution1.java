package dp.medium.jump_game;

import org.junit.Test;

public class Solution1 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len==1){
            return true;
        }
        if (nums[0]==0){
            return false;
        }
        int reach = 0;
        for (int i = 0; i < len; i++) {
            if(i<=reach){
                reach=Math.max(reach,i+nums[i]);
                if (reach>=len-1){
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(canJump(new int[]{0,1}));
    }
}
