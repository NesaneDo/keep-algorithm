### 题目

#### [953. Verifying an Alien Dictionary](https://leetcode.cn/problems/verifying-an-alien-dictionary/)

难度简单139

In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different `order`. The `order` of the alphabet is some permutation of lowercase letters.

Given a sequence of `words` written in the alien language, and the `order` of the alphabet, return `true` if and only if the given `words` are sorted lexicographically in this alien language.

 

**Example 1:**

```
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
```

**Example 2:**

```
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
```

**Example 3:**

```
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
```

 

**Constraints:**

- `1 <= words.length <= 100`
- `1 <= words[i].length <= 20`
- `order.length == 26`
- All characters in `words[i]` and `order` are English lowercase letters.

> #### [953. 验证外星语词典](https://leetcode.cn/problems/verifying-an-alien-dictionary/)
>
> 难度简单139
>
> 某种外星语也使用英文小写字母，但可能顺序 `order` 不同。字母表的顺序（`order`）是一些小写字母的排列。
>
> 给定一组用外星语书写的单词 `words`，以及其字母表的顺序 `order`，只有当给定的单词在这种外星语中按字典序排列时，返回 `true`；否则，返回 `false`。
>
>  
>
> **示例 1：**
>
> ```
> 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
> 输出：true
> 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
> ```
>
> **示例 2：**
>
> ```
> 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
> 输出：false
> 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
> ```
>
> **示例 3：**
>
> ```
> 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
> 输出：false
> 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
> ```
>
>  
>
> **提示：**
>
> - `1 <= words.length <= 100`
> - `1 <= words[i].length <= 20`
> - `order.length == 26`
> - 在 `words[i]` 和 `order` 中的所有字符都是英文小写字母。

### 解法

1. 使用 `HashMap` 将 `26` 个字母及顺序存起来，再两两比较字符串，使用更短的字符串

   **参考代码：**

   ```java
   /**
    * 使用 hash 表
    * 1、将 order 各字符及其顺序用 HashMap 存起来
    * 2、两两比较 words，使用长度更短的进行比较，若存在 false 则直接返回
    * 3、若为 true 则判断长度，若长度更长的在前，则返回 false，否则往下一轮比较
    */
   public boolean isAlienSorted1(String[] words, String order) {
       Map<Character, Integer> map = new HashMap<>(32);
       for (int i = 0; i < order.length(); i++) {
           map.put(order.charAt(i), i);
       }
       int shorter, longer, t, j;
       for (int i = 0; i < words.length - 1; i++) {
           shorter = words[i].length() <= words[i + 1].length() ? i : i + 1;
           longer = shorter == i ? i + 1 : i;
           j = 0;
           for (; j < words[shorter].length(); j++) {
               // 正确的顺序 shorter == i && t < 0
               t = map.get(words[shorter].charAt(j)) - map.get(words[longer].charAt(j));
               if (shorter == i ? t < 0 : t > 0) {
                   break;
               }
               if (shorter == i ? t > 0 : t < 0) {
                   return false;
               }
           }
           if (longer == i && j == words[shorter].length()) {
               return false;
           }
       }
       return true;
   }
   ```

   **复杂度：**
   $$
   \begin{cases} 时间复杂度：O(n \times m)，n 为 words的长度，m为各字符串的长度\\\\空间复杂度：O(1)，只使用了有限个变量 \end{cases}
   $$

2. 将方法一中的 `HashMap` 换成数组

   **参考代码：**

   ```java
   /**
    * 将方法一中的 HashMap 换成数组，会快很多
    */
   public boolean isAlienSorted2(String[] words, String order) {
       int[] map = new int[order.length()];
       for (int i = 0; i < map.length; i++) {
           map[order.charAt(i) - 'a'] = i;
       }
       System.out.println(Arrays.toString(map));
       int shorter, longer, t, j;
       for (int i = 0; i < words.length - 1; i++) {
           shorter = words[i].length() <= words[i + 1].length() ? i : i + 1;
           longer = shorter == i ? i + 1 : i;
           j = 0;
           for (; j < words[shorter].length(); j++) {
               // 正确的顺序 shorter == i && t < 0
               t = map[words[shorter].charAt(j) - 'a'] - map[words[longer].charAt(j) - 'a'];
               if (shorter == i ? t < 0 : t > 0) {
                   break;
               }
               if (shorter == i ? t > 0 : t < 0) {
                   return false;
               }
           }
           if (longer == i && j == words[shorter].length()) {
               return false;
           }
       }
       return true;
   }
   ```

   **复杂度：**
   $$
   \begin{cases} 时间复杂度：O(n \times m)，n 为 words的长度，m为各字符串的长度\\\\空间复杂度：O(1)，只使用了有限个变量 \end{cases}
   $$

