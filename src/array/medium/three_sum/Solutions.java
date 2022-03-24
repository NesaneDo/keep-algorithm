package array.medium.three_sum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和 LeetCode 15 【中等】
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc 三数之和 LeetCode 15 【中等】
 * @since 2022/3/2
 */
public class Solutions {
    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        // 指定一个位置i，后使用双指针获取 i 后面两头的数字，位置记录为 l,r
        // 判断 int sum=nums[i]+nums[l]+nums[r]
        // 1、 sum > 0，表示 r 的数字过大，r--, r 往左移之后，若 nums[r] == nums[--r] 跳过
        // 2、 sum < 0，表示 l 的数字过小，l++, l 往右移之后，若 nums[l] == nums[++l] 跳过
        // 3、 在 r 左移或 l 右移的过程中发现 sum==0 则记录一个结果，并且 r--,l++
        // 4、 若 l >= r, 则 i++ ，若 nums[i] == nums[++i] 跳过
        // 5、重复 1-4
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i<len; i++) {
            int l = i + 1, r = len - 1;
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    ++l;
                    --r;
                }
                else if (sum > 0) {
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4, 5, 3, 6, 1, -3, -6, -3, 9, -3}));
    }
}
