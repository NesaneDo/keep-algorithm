package array.hard.median_of_two_sorted_arrays;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Rondo Chan
 * @version 1.0.0
 * @desc
 * @since 2021/9/7
 */
public class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] num3 = new int[len1 + len2];
        int[] numS = len1 < len2 ? nums1 : nums2;
        int[] numL = len1 < len2 ? nums2 : nums1;
        int lenS = numS.length;
        int lenL = numL.length;

        int i = 0, j = 0, k = 0;
        while (i <lenS && j <lenL) {
            if (numS[i] < numL[j]) {
                num3[k++] = numS[i++];
            } else {
                num3[k++] = numL[j++];
            }
        }
        while (i <lenS) {
            num3[k++] = numS[i++];
        }
        while (j <lenL) {
            num3[k++] = numL[j++];

        }
        System.out.println(Arrays.toString(num3));
        return (len & 1) == 0 ? (double) (num3[len / 2] + num3[len / 2 - 1])/2 : num3[len / 2];
    }

    @Test
    public void test() {
        System.out.println(findMedianSortedArrays(new int[]{1,2,5,6,7}, new int[]{2, 4}));
    }
}
