package impl.medium.insert_delete_getrandom_o1;

import java.util.*;

/**
 * LeetCode 380. O(1) 插入、删除和获取随机元素
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 380. O(1) 插入、删除和获取随机元素
 * @since 2022/4/13
 */
public class RandomizedSet {
    private static final int MOST = 5 * 10000;
    private final Map<Integer, Integer> map = new HashMap<>(MOST);
    private final int[] elements = new int[MOST];
    private int cur = 0;
    private static final Random RANDOM = new Random();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        elements[cur] = val;
        map.put(val, cur++);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int key = map.remove(val);
        // 删除的不是最后一个，则需要将最后一个元素移动到被删除的位置
        if(key!=cur-1){
            map.put(elements[cur-1],key);
        }
        elements[key]=elements[--cur];
        return true;
    }

    public int getRandom() {
        return elements[RANDOM.nextInt(cur)];
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.map);
        System.out.println(Arrays.toString(randomizedSet.elements));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.getRandom());

        System.out.println(randomizedSet.map);
        System.out.println(Arrays.toString(randomizedSet.elements));
        System.out.println(randomizedSet.cur);
//        System.out.println(randomizedSet.insert(2));
//        System.out.println(randomizedSet.getRandom());
//        System.out.println(randomizedSet.remove(1));
//        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
//        for (int i = 0; i < 1000; i++) {
//            System.out.println(randomizedSet.getRandom());
//        }
    }
}
