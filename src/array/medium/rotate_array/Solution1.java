package array.medium.rotate_array;

/**
 * 使用临时数组
 * @author Rondo Chan
 * @desc 使用临时数组
 * @since 2021/7/22
 * @version 1.0.0
 */
public class Solution1 {
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        // 防止出现 k > len 的情况
        k%=len;
        int[] temp=new int[len];
        System.arraycopy(nums, 0, temp, 0, len);
        for(int i=0,j=len-k;i<len;i++,j++){
            // j%=len：j 从 len-k 开始，就是开始分割数组的地方，到达数组末尾时即 j%len==0 的时候，从头开始
            nums[i]=temp[j%=len];
        }
    }
}
