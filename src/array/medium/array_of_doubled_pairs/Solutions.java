package array.medium.array_of_doubled_pairs;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;

/**
 * LeetCode 954. 二倍数对数组
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 954. 二倍数对数组
 * @since 2022/4/1
 */
public class Solutions {
    public boolean canReorderDoubled(int[] arr) {
        int len = arr.length;
        Integer[] nrr = new Integer[len];
        for (int i = 0; i < len; i++) {
            nrr[i] = arr[i];
        }
        Arrays.sort(nrr, Comparator.comparingInt(a -> a));
        System.out.println(Arrays.toString(nrr));
        // 保存整数和对应的数量
        Map<Integer, Integer> map = new HashMap<>(len);
        // 排序之后将后一半的数据添加到 map 中
        for (int i = len - 1; i >= 0; i--) {
            map.put(nrr[i], map.getOrDefault(nrr[i], 0) + 1);
        }
        System.out.println(map);
        // 再遍历前一半的数据，判断 map 中是否存在 2 * arr[i]，有则将 map 对应 key 的 value - 1
        for (int value : nrr) {
            int k = 2 * value;
            if (map.containsKey(k) && map.get(k) > 0 && map.get(value) > 0) {
                map.put(k, map.get(k) - 1);
                map.put(value, map.get(value) - 1);
            }
        }
        // 最后再统计 map 所有值的和是否等于 0
        System.out.println(map);
//        return map.values().stream().filter(i->i!=0).mapToInt(Integer::intValue).sum()==0;
        int sum=0;
        int valSum=0;
        for(Map.Entry<Integer,Integer> en:map.entrySet()){
            sum+=en.getKey()*en.getValue();
            valSum+=en.getValue();
        }
        return sum==0&&valSum==0;
    }

    @Test
    public void test() {
        System.out.println(canReorderDoubled(new int[]{-1000,1000}));
        System.out.println(canReorderDoubled(new int[]{2,1,2,4,0,0,4,8,7,14,-9,-4,-8,-4,-2,-18}));
        System.out.println(canReorderDoubled(new int[]{2,2,2,1,1,1,1,2,1,2}));
        System.out.println(canReorderDoubled(new int[]{2,2,2,1,1,1,1,2,1,2,2,1,2,4,0,0,4,8,7,14,-9,-4,-8,-4,-2,-18}));
        System.out.println(canReorderDoubled(new int[]{2,1,2,4,0,0,4,8,7,14,-9,-4,-8,-4,-2,-18,2,2,2,1,1,1,1,2,1,2}));
    }
}
