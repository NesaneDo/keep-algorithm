package math.medium.count_numbers_with_unique_digits;

/**
 * LeetCode 357. 统计各位数字都不同的数字个数
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 357. 统计各位数字都不同的数字个数
 * @since 2022/4/11
 */
public class Solutions {
    /**
     * 规律如下：
     * n        0        1          2               3                       4
     * ans      1        10         91              739                     5275
     * f(n)     1        9+f(0)     9*9+f(1)+f(0)   9*9*8+f(2)+f(1)+f(0)    9*9*8*7+f(3)+...+f(0)
     */
    public int countNumbersWithUniqueDigits(int n) {
        int sum = 1, a;
        for (int i = 1; i <= n; i++) {
            a = 9;
            for (int j = 1; j < i; j++) {
                a *= 10 - j;
            }
            sum += a;
        }
        return sum;
    }

}
