> **思路 1：使用 Stack 和 HashMap**

nums1 是 nums2 的子集，即 nums2 中所有元素来自于 nums2，且是没有重复的。

思路：对 nums2 遍历，同时记录 nums2 中每个元素的下一个更大值并用 hash map 保存下来，nums2 遍历完成后，hash map 中已经保存了每个元素的下一个更大值，再去遍历 nums1，在 hash map 中找到对应关系即可。

具体操作：

1. 遍历 nums2，若当前元素比栈顶元素小，直接压入栈中，若当前元素比栈顶元素大，出栈，直到栈中没有比当前元素大的元素
2. 与步骤 1 同时进行的，是在出栈时，使用 hash map 保存，以 key = 出栈元素，value = 当前元素的形式
3. 将当前元素入栈
4. 遍历 nums1，找到 hash map 中对应的值，若没有则为 -1

**时间复杂度: O(n+m): n，m分别为 nums2 和 nums1 的长度**

**时间复杂度: O(n)：n为 nums2 的长度**

**参考代码**

```java
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
```

