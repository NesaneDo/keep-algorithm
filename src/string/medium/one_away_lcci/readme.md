### 题目

#### [面试题 01.05. One Away LCCI](https://leetcode.cn/problems/one-away-lcci/)

难度中等202收藏分享切换为中文接收动态反馈

There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.

 

**Example 1:**

```
Input: 
first = "pale"
second = "ple"
Output: True
```

**Example 2:**

```
Input: 
first = "pales"
second = "pal"
Output: False
```



> #### [面试题 01.05. 一次编辑](https://leetcode.cn/problems/one-away-lcci/)
>
> 难度中等202收藏分享切换为英文接收动态反馈
>
> 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
>
>  
>
> **示例 1:**
>
> ```
> 输入: 
> first = "pale"
> second = "ple"
> 输出: True
> ```
>
>  
>
> **示例 2:**
>
> ```
> 输入: 
> first = "pales"
> second = "pal"
> 输出: False
> ```

### 

### 解法

使用双指针分别从两个字符串开始和结尾往中间遍历，遇到不相同的字符停止，记录相同字符的个数 `same`，最后比较两个字符串与 `same` 的差值是否小于2

### 参考代码

```java
public boolean oneEditAway(String first, String second) {
    int fn = first.length() - 1, sn = second.length() - 1;
    if (Math.abs(fn - sn) > 1) {
        return false;
    }
    int i = 0, j = 0, same = 0;
    while (i <= fn && j <= sn && first.charAt(i++) == second.charAt(j++)) {
        same++;
    }
    while (fn >= 0 && sn >= 0 && first.charAt(fn--) == second.charAt(sn--)) {
        same++;
    }
    return first.length() - same < 2 && second.length() - same < 2;
}
```

### 复杂度

$$
\begin{cases} 时间复杂度：O(n)，n 为 两个字符串长度更小的值\\\\ 空间复杂度：O(1)\end{cases}
$$

