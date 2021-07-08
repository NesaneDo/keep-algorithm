package dp.easy.pascal_triangle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc 杨辉三角
 * @since 2021/7/1
 */
public class Solution1 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows<=0){
            return res;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    t.add(1);
                } else {
                    t.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(t);
        }
        return res;
    }
}
