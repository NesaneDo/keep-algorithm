package array.easy.plus_one;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * @author Rondo Chan
 * @desc
 * @since 2021/6/30
 * @version 1.0.0
 */
public class Solution1 {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        for(int i=len-1;i>=0;i--){
            digits[i]++;
            digits[i]%=10;
            if (digits[i]!=0){
                return digits;
            }
        }
        digits=new int[len+1];
        digits[0]=1;
        return digits;
    }
    @Test
    public void test(){
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9})));
    }
}
