# 题目

#### [205. 同构字符串](https://leetcode.cn/problems/isomorphic-strings/)

难度简单521收藏分享切换为英文接收动态反馈

给定两个字符串 `s` 和 `t` ，判断它们是否是同构的。

如果 `s` 中的字符可以按某种映射关系替换得到 `t` ，那么这两个字符串是同构的。

每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

 

**示例 1:**

```
输入：s = "egg", t = "add"
输出：true
```

**示例 2：**

```
输入：s = "foo", t = "bar"
输出：false
```

**示例 3：**

```
输入：s = "paper", t = "title"
输出：true
```

 

**提示：**



- `1 <= s.length <= 5 * 104`
- `t.length == s.length`
- `s` 和 `t` 由任意有效的 ASCII 字符组成

# 解法

### 1、哈希表

提到映射，哈希表就是天然的映射结构：同时遍历两个字符串，将 s 中的字符串映射到 t 中的字符，当遇到重复字符时，判断哈希表中的映射与 t 当前的字符是否相同。**需要注意的是：`单向映射是不可靠的，比如当 s 中的字符各不相同，则 s 中的字符可以全部映射到 t 中，但是 t 中的字符却可能重复，所有需要再从 t 映射到 s`**

**参考代码：**

```java
public boolean isIsomorphic(String s, String t) {
    return h(s,t)&&h(t,s);
}
public boolean h(String s, String t) {
    if(s.length()!=t.length())return false;
    Map<Character,Character> sm=new HashMap<>(s.length());
    for(int i=0;i<s.length();i++){
        char sc=s.charAt(i);
        char tc=t.charAt(i);
        if(sm.containsKey(sc)&&sm.get(sc)!=tc) return false;
        sm.put(sc,tc);
    }
    return true;
}
```

**复杂度分析：**
$$
\begin{cases}时间复杂度：O(n)，2 次遍历字符串 \\\\空间复杂度：O(n)，需要一个哈希表来作映射表 \end{cases}
$$


### 2、数字映射

将两个字符串映射为另一个格式的字符串，以保证新字符串可以比较。可以选择数字作为映射，比如将 "abcd" -> "1234", "aabb" -> "1122", 即把相同的字符映射成相同的数字。再比较两个新数字字符串是否相同。

**参考代码：**

```java
public boolean isIsomorphic2(String s, String t) {
    return h2(s).equals(h2(t));
}
public String h2(String s) {
    int[] cs=new int[128];
    int i=0;
    StringBuilder sb=new StringBuilder();
    for(char c:s.toCharArray()){
        if(cs[c]==0)cs[c]=++i;
        sb.append(cs[c]);
    }
    return sb.toString();
}
```

**复杂度分析：**


$$
\begin{cases}时间复杂度：O(n)，2 次遍历字符串 \\\\空间复杂度：O(n)，使用了 2 个 StringBuilder 来保存映射后的字符串 \end{cases}
$$
