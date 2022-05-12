package string.easy.delete_columns_to_make_sorted;

/**
 * LeetCode 944. Delete Columns To Make Sorted
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 944. Delete Columns To Make Sorted
 * @since 2022/5/12
 */
public class Solutions {
    public int minDeletionSize(String[] strs) {
        int row = strs.length, col = strs[0].length();
        int res = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
