package array.medium.sum_of_subarray_ranges;

/**
 * LeetCode 2104.子数组范围之和
 * @author Rondo Chan
 * @desc LeetCode 2104.子数组范围之和
 * @since 2022/3/4
 * @version 1.0.0
 */
public class Solutions {
    /**
     * 暴力：双重循环
     */
    public long subArrayRanges1(int[] nums) {
        long sum=0;
        for(int i=0;i<nums.length-1;i++){
            int max=nums[i],min=nums[i];
            for(int j=i+1;j<nums.length;j++){
                max=Math.max(max,nums[j]);
                min=Math.min(min,nums[j]);
                sum+=max-min;
            }
        }
        return sum;
    }


}
