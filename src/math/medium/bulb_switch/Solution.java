package math.medium.bulb_switch;

import org.junit.Test;

import java.util.Arrays;

/**
 * 循环，这个会超时
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc 循环
 * @since 2021/11/15
 */
public class Solution {
    public int bulbSwitch(int n) {
        boolean[] sta = new boolean[n];
        for (int i = 1; i <= n; i++) {
            for (int j = i-1; j < sta.length; ) {
                sta[j] = !sta[j];
                j += i;
            }
        }
        int res = 0;
        int [] t=new int[n];
        int k=0;
        for (boolean b : sta) {
            t[k++]=b?1:0;
            if (b) {
                res++;
            }
        }
        if(n<10)
            System.out.println("第 "+n+"  轮结果 : "+Arrays.toString(t));
        else{
            System.out.println("第 "+n+" 轮结果 : "+Arrays.toString(t));

        }
        return res;
    }

    public int bulbSwitch2(int n) {
        return (int) Math.sqrt(n);
    }
    @Test
    public void test() {
        for(int i=0;i<=100;i++){
            int res=bulbSwitch(i);
//            String desc=" 轮结果：";
//            if(i<10){
//                desc="  轮结果：";
//            }
//            System.out.print("第 " +i+desc+res+" | ");
//            if ((i+1)%10==0){
//                System.out.println();
//            }
        }
    }
}
