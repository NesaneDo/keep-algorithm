package stack.easy.next_greater_el_I;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Rondo Chan
 * @version 1.0.0
 * @description 使用 Stack 和 HashMap
 * @since 2021/4/17 9:51
 */
public class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Deque<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>(len2);
        // 对 nums2 遍历，找到每个元素的下一个更大值
        for (int n : nums2) {
            // 保证 Stack 中自顶向下单调不减，并且在出栈时 hashmap 记录关系：key：弹出的 value:压入的
            while (!stack.isEmpty() && n > stack.peek()) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }
        int[] res = new int[len1];
        // 对 nums1 遍历，根据 hashmap 查找
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
