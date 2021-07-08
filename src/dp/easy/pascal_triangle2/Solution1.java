package dp.easy.pascal_triangle2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角2
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc 杨辉三角2
 * @since 2021/7/8
 */
//        [1],
//       [1,1],
//      [1,2,1],
//     [1,3,3,1],
//    [1,4,6,4,1]
public class Solution1 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        int[] ints = new int[rowIndex+1];
        if (rowIndex == 0) {
            ints[0] = 1;
        } else if (rowIndex == 1) {
            ints[0] = ints[1] = 1;
        } else {
            ints[0] = ints[rowIndex] = 1;
            for (int i = 1; i <= rowIndex / 2; i++) {
                ints[i] = ints[rowIndex - i] = ints[i - 1] * (rowIndex - i+1) / i;
            }
        }
        for (int i : ints) {
            res.add(i);
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(getRow(0));
        System.out.println(getRow(1));
        System.out.println(getRow(2));
        System.out.println(getRow(3));
        System.out.println(getRow(4));
        System.out.println(getRow(5));
        System.out.println(getRow(6));
        System.out.println(getRow(7));
        System.out.println(getRow(8));
        System.out.println(getRow(9));
        System.out.println(getRow(10));
        System.out.println(getRow(11));
        System.out.println(getRow(12));
    }
}
