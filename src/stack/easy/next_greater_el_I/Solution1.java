package stack.easy.next_greater_el_I;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Rondo Chan
 * @version 1.0.0
 * @description  暴力循环
 * @since 2021/4/17 9:50
 */
public class Solution1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;
            int n2 = nums2.length - 1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    n2 = j;
                }
                if (nums2[j] > nums1[i] && j > n2) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
