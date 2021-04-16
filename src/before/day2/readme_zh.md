# LeetCode #347 - 前 K 个高频元素   

给定一个非空的整数数组，返回其中出现频率前 `k` 高的元素。  

#### 示例 1:  

**输入:** `nums = [1,1,1,2,2,3], k = 2`  
**输出:** `[1,2]`  

#### 示例 2:  

**输入:** `nums = [1], k = 1`     
**输出:** `[1]`  


#### 提示：

- 你可以假设给定的 `k` 总是合理的，且 `1 ≤ k ≤ 数组中不相同的元素的个数`。
- 你的算法的时间复杂度必须优于 `O(n log n)` , `n` 是数组的大小。
- 题目数据保证答案唯一，换句话说，数组中前 `k` 个高频元素的集合是唯一的。
- 你可以按任意顺序返回答案。


>来源：力扣（LeetCode）
>链接：https://leetcode-cn.com/problems/top-k-frequent-elements
>著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

****

### 解法一：

1. 将数组遍历一遍，用一个 **`HashMap`** 记录每个数字出现的次数，此时的时间复杂度是 **`O(n)`**。
2. 对 **`HashMap`** 中的 **值（value）** 进行排序，选择前 **`k`** 个 **键（key）**输出。但题目要求时间复杂度必须优于 **`O(nlogn)`**，所以可以选择 **堆排序** 或 **归并排序**，这样总体的时间复杂度就是 **`O(n)+O(nlogn)`**，也就是 **`O(nlogn)`**。