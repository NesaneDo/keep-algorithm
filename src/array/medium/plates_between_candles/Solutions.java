package array.medium.plates_between_candles;

import org.junit.Test;

import java.util.Arrays;

/**
 * LeetCode 2055. 蜡烛之间的盘子
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 2055. 蜡烛之间的盘子
 * @since 2022/3/8
 */
public class Solutions {
    /**
     * <h3>前缀和</h3>
     * 使用一个数组 plates 保存各位置的盘子数量，<br>
     * 再使用一个数组 candles 保存各位置蜡烛数量，<br>
     * 再使用一个数组 lastCandlePos 保存上一支蜡烛的位置，<br>
     * 判断查询 queries 中 queries[0] 和 queries[1] 的蜡烛数 c1 和 c2，若 c2-c1<=1, 说明该查询中没有被蜡烛包围，盘子数量为0,<br>
     * 若 c2-c1 > 1，说明该查询被蜡烛包围，获取到蜡烛的最小位置 pmin 和最大位置 pmax，该查询的盘子数量为 pmax-pmin
     *
     * @param s       字符串
     * @param queries 查询
     * @return 各查询中盘子个数
     */
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        if (len == 0) {
            return new int[len];
        }
        // 使用一个数组 plates 保存各位置的盘子数量前缀和
        int[] plates = new int[len];
        // 再使用一个数组 candles 保存各位置蜡烛数量前缀和
        int[] candles = new int[len];
        // 再使用一个数组 lastCandlePos 保存上一支蜡烛的位置
        int[] lastCandlePos = new int[len];
        // 再使用一个数组 lastCandlePos 保存下一支蜡烛的位置
        int[] nextCandlePos = new int[len];
        // 第一个位置是否是蜡烛
        lastCandlePos[0] = s.charAt(0) == '|' ? 0 : -1;
        plates[0] = 1;
        boolean isAllCandle=s.charAt(0) == '|';
        boolean isAllPlates=s.charAt(0) == '*';
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '*') {
                plates[i] = plates[i - 1] + 1;
                candles[i] = candles[i - 1];
                lastCandlePos[i] = lastCandlePos[i - 1];
                isAllCandle=false;
            } else {
                plates[i] = plates[i - 1];
                candles[i] = candles[i - 1] + 1;
                lastCandlePos[i] = i;
                isAllPlates=false;
            }
        }
        int[] res = new int[queries.length];
        if(isAllCandle||isAllPlates){
            return res;
        }
        nextCandlePos[len - 1] = s.charAt(len - 1) == '|' ? len - 1 : -1;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '*') {
                nextCandlePos[i] = nextCandlePos[i + 1];
            } else {
                nextCandlePos[i] = i;
            }
        }
        // 将记录上一支蜡烛的位置中为 -1 的情况变成第一支蜡烛的位置
        int i = 0;
        for (; i < len; i++) {
            if (lastCandlePos[i] > 0) {
                break;
            }
        }
        for (int j = 0; j < i - 1&&--i>0; j++) {
            lastCandlePos[j] = lastCandlePos[i];
        }
        int j = len - 1;
        for (; j >= 0; j--) {
            if (nextCandlePos[j] > 0) {
                break;
            }
        }
        for (int k = len - 1; k >= j; k--) {
            nextCandlePos[k] = lastCandlePos[j];
        }
        int p = 0;
        for (int[] q : queries) {
            if(candles[q[1]]-candles[q[0]]>0){
                res[p++] = plates[lastCandlePos[q[1]]] - plates[nextCandlePos[q[0]]];
            }else{
                res[p++]=0;
            }
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    @Test
    public void test() {
        String s="***";
        int [][] a=new int[][]{{2,2}};
        platesBetweenCandles(s,a);
//        platesBetweenCandles(
//                "***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}});
    }
}
