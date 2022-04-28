package array.easy.sort_arrary_by_parity;

import java.util.Arrays;

/**
 * LeetCode 905. Sort Array By Parity
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 905. Sort Array By Parity
 * @since 2022/4/28
 */
public class Solutions {
    /**
     * 遍历原数组，若当前元素为偶数，则往前放，否则往后放
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] sortArrayByParity(int[] nums) {
        int start = 0, end = nums.length;
        int[] ans = new int[end];
        for (int n : nums) {
            ans[(n & 1) == 0 ? start++ : --end] = n;
        }
        return ans;
    }


    /**
     * 双指针，当开始指针为奇数并且结尾指针为偶数时交换，否则移动对应指针向前或向后
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int[] sortArrayByParity2(int[] nums) {
        int start = 0, end = nums.length - 1, t;
        while (start < end) {
            while ((nums[start] & 1) == 0 && start < end) start++;
            while ((nums[end] & 1) == 1 && start < end) end--;
            t = nums[start];
            nums[start++] = nums[end];
            nums[end--] = t;
        }
        return nums;
    }

    /**
     * 一次遍历
     * 使用一个变量来保存当前偶数所在的下标 n，初始值为 0，依次遍历元素 i，当遇到偶数时 交换 n 与 i
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int[] sortArrayByParity3(int[] nums) {
        int n = 0, t;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {
                t = nums[i];
                nums[i]=nums[n];
                nums[n++] = t;
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solutions().sortArrayByParity3(new int[]{21,3,41,3,1,3,4,15,123,41,234, 4})));
    }
}
