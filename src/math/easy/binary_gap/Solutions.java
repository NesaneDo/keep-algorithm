package math.easy.binary_gap;

/**
 * LeetCode 868. 二进制间距
 * @author Rondo Chan
 * @desc LeetCode 868. 二进制间距
 * @since 2022/4/24
 * @version 1.0.0
 */
public class Solutions {
    public int binaryGap(int n) {
        // 位运算：用 i 循环，每次 n >>= 1，相当于除以 2，再用 n & 1，保存为 1 的时候的 i，last 为上一次记录的 i，初始值为 -1，
        // 每次循环记录 结果与 i-last 较大值
        int ans = 0, last = -1, i = 0;
        while(n != 0) {
            // n & 1 表示获取最低位的值
            if(1 == (n & 1)) {
                ans = Math.max(ans, last < 0 ? -1 : i - last);
                last = i;
            }
            n >>= 1;
            i++;
        }
        return ans;
    }
}
