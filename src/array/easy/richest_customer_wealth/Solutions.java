package array.easy.richest_customer_wealth;

import java.util.Arrays;

/**
 * 1672. 最富有客户的资产总量
 * @author Rondo Chan
 * @desc 1672. 最富有客户的资产总量
 * @since 2022/4/14
 * @version 1.0.0
 */
public class Solutions {
    public int maximumWealth(int[][] accounts) {
        // 慢
        return Arrays.stream(accounts).mapToInt(a->Arrays.stream(a).sum()).max().getAsInt();
    }
}
