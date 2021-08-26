package array.easy.merge_sroted_array;

import org.junit.Test;

import java.util.Arrays;

public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            if (n >= 0) {
                System.arraycopy(nums2, 0, nums1, 0, n);
            }
            return;
        }
        int len = nums1.length;
        int i = n - 1, j = m - 1;
        while (i>=0&&j>=0) {
            if (nums1[j] <= nums2[i]) {
                nums1[--len] = nums2[i--];
            } else {
                nums1[--len] = nums1[j--];
            }
        }
        while(j<i){
            nums1[--len]=nums2[i--];
        }
    }

    @Test
    public void test() {
        int[] ints = {1,0};
        merge(ints, 1, new int[]{2}, 1);
        System.out.println(Arrays.toString(ints));
    }
}
