package array.medium.rotate_function;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * LeetCode 396. 旋转函数
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 396. 旋转函数
 * @since 2022/4/22
 */
public class Solutions {
    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        int max = 0;
        int[] partialSums = new int[len * 2];
        partialSums[0] = nums[0];
        for (int i = 1; i < len * 2; i++) {
            // 不要第一个元素的原因：公共部分元素下标最低从 1 开始
            partialSums[i] = partialSums[i - 1] + nums[(i - 1) % len];
        }

        // 计算原数组的 f(0)：即还未进行旋转前的 F 值
        for (int i = 0; i < len; i++) {
            max += nums[i] * i;
        }
        // 只需旋转 len - 1 次
        for (int i = len + 1, fx = max; i < len * 2; i++) {
            // 旋转之后，加上最新在末尾的值 nums[(len+i)%len] * (len - 1);
            fx += nums[(i - 1) % len] * (len - 1);
            // 再减去 num[(len - 1 + i) % len] * 0, 恒等于 0，则跳过
            // 再加上除首尾外的公共部分的差值：nums[i + 1] + nums[i + 2] + ... + nums[i + len - 1]
            // 即 partialSums[i - len] - partialSums[i - 1]
            fx += partialSums[i - len] - partialSums[i - 1];

            if (fx > max) {
                max = fx;
            }
        }
        return max;
    }

    public int maxRotateFunction2(int[] nums) {
        // 找规律：
        // F(n) = F(n - 1) + sum - len * (nums[len - n])
        int f0 = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            f0 += nums[i] * i;
            sum += nums[i];
        }
        int max = f0;
        for (int i = 1; i < nums.length; i++) {
            f0 = f0 + sum - nums.length * (nums[nums.length - i]);
            max = Math.max(f0, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solutions().maxRotateFunction(new int[]{4, 3, 2, 6, 1}));
        System.out.println(new Solutions().maxRotateFunction2(new int[]{4, 3, 2, 6, 1}));
    }
}
