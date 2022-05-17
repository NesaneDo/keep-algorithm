package string.easy.verifying_an_alien_dictionary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 953. Verifying an Alien Dictionary
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 953. Verifying an Alien Dictionary
 * @since 2022/5/17
 */
public class Solutions {
    /**
     * 使用 hash 表
     * 1、将 order 各字符及其顺序用 HashMap 存起来
     * 2、两两比较 words，使用长度更短的进行比较，若存在 false 则直接返回
     * 3、若为 true 则判断长度，若长度更长的在前，则返回 false，否则往下一轮比较
     */
    public boolean isAlienSorted1(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>(32);
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        int shorter, longer, t, j;
        for (int i = 0; i < words.length - 1; i++) {
            shorter = words[i].length() <= words[i + 1].length() ? i : i + 1;
            longer = shorter == i ? i + 1 : i;
            j = 0;
            for (; j < words[shorter].length(); j++) {
                // 正确的顺序 shorter == i && t < 0
                t = map.get(words[shorter].charAt(j)) - map.get(words[longer].charAt(j));
                if (shorter == i ? t < 0 : t > 0) {
                    break;
                }
                if (shorter == i ? t > 0 : t < 0) {
                    return false;
                }
            }
            if (longer == i && j == words[shorter].length()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将方法一中的 HashMap 换成数组，会快很多
     */
    public boolean isAlienSorted2(String[] words, String order) {
        int[] map = new int[order.length()];
        for (int i = 0; i < map.length; i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        System.out.println(Arrays.toString(map));
        int shorter, longer, t, j;
        for (int i = 0; i < words.length - 1; i++) {
            shorter = words[i].length() <= words[i + 1].length() ? i : i + 1;
            longer = shorter == i ? i + 1 : i;
            j = 0;
            for (; j < words[shorter].length(); j++) {
                // 正确的顺序 shorter == i && t < 0
                t = map[words[shorter].charAt(j) - 'a'] - map[words[longer].charAt(j) - 'a'];
                if (shorter == i ? t < 0 : t > 0) {
                    break;
                }
                if (shorter == i ? t > 0 : t < 0) {
                    return false;
                }
            }
            if (longer == i && j == words[shorter].length()) {
                return false;
            }
        }
        return true;
    }
}
