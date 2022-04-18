package tree.medium.lexicographical_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc 386. 字典序排数
 * @since 2022/4/18
 */
public class Solutions {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        int i = 1;
        while (res.size() < n) {
            res.add(i);
            if (i * 10 <= n) {
                i *= 10;
            } else {
                while (i % 10 == 9 || i > n - 1) {
                    i /= 10;
                }
                i++;
            }
        }

        return res;
    }
}
