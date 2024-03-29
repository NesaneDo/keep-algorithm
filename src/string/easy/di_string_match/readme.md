#### [942. DI String Match](https://leetcode.cn/problems/di-string-match/)

难度简单284收藏分享切换为中文接收动态反馈

A permutation `perm` of `n + 1` integers of all the integers in the range `[0, n]` can be represented as a string `s` of length `n` where:

- `s[i] == 'I'` if `perm[i] < perm[i + 1]`, and
- `s[i] == 'D'` if `perm[i] > perm[i + 1]`.

Given a string `s`, reconstruct the permutation `perm` and return it. If there are multiple valid permutations perm, return **any of them**.

 

**Example 1:**

```
Input: s = "IDID"
Output: [0,4,1,3,2]
```

**Example 2:**

```
Input: s = "III"
Output: [0,1,2,3]
```

**Example 3:**

```
Input: s = "DDI"
Output: [3,2,0,1]
```

 

**Constraints:**

- `1 <= s.length <= 105`
- `s[i]` is either `'I'` or `'D'`.



> 中文版

#### [942. 增减字符串匹配](https://leetcode.cn/problems/di-string-match/)

难度简单284收藏分享切换为英文接收动态反馈

由范围 `[0,n]` 内所有整数组成的 `n + 1` 个整数的排列序列可以表示为长度为 `n` 的字符串 `s` ，其中:

- 如果 `perm[i] < perm[i + 1]` ，那么 `s[i] == 'I'` 
- 如果 `perm[i] > perm[i + 1]` ，那么 `s[i] == 'D'` 

给定一个字符串 `s` ，重构排列 `perm` 并返回它。如果有多个有效排列perm，则返回其中 **任何一个** 。

 

**示例 1：**

```
输入：s = "IDID"
输出：[0,4,1,3,2]
```

**示例 2：**

```
输入：s = "III"
输出：[0,1,2,3]
```

**示例 3：**

```
输入：s = "DDI"
输出：[3,2,0,1]
```

 

**提示：**

- `1 <= s.length <= 105`
- `s` 只包含字符 `"I"` 或 `"D"`