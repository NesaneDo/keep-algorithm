package stack.easy.build_an_array_with_stack_operations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 设置一个从 1 开始的计数器 count，遍历数组，
 * 若当前数字小于 n 且不等于 count，则先 push 再 pop，不进行数组下一个遍历；
 * 若等于 count 则只 push，并遍历数组中下一个数字
 * @author Rondo Chan
 * @desc
 * @since 2021/6/17
 * @version 1.0.0
 */
public class Solution1 {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> list = new ArrayList<>();
        if (target==null||target.length==0||n==0){
            return list;
        }
        for(int count=1,i=0;count<=n;count++){
            if (i>target.length-1){
                break;
            }
            if(target[i]==count){
                list.add("Push");
                i++;
            }else{
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }

    @Test
    public void test(){
        System.out.println(buildArray(new int[]{1,2},4));
    }
}
