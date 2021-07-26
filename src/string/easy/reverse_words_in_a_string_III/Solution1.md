> 解法一：使用空格来界定一个单词，而非使用 split 函数

先初始化一个标识一个单词开始下标的变量 `is = 0`，遍历字符数组（使用 toCharArray()方法），当遇到 **空格** 的时候就表示一个完整的单词出现，则可以根据 `is` 和 当前的遍历索引进行单词的反转。

**注意：**需要注意的是，根据空格来标识完整的单词对结尾的单词不好界定，所以简单的解决方式就是 **提前在单词结尾添加一个空格**

**参考代码：**

```java
public String reverseWords(String s) {
    if (s == null || s.trim().length() == 0) {
        return s;
    }
    s += " ";
    int is = 0;
    char[] cs = s.toCharArray();
    for (int i = 0; i < cs.length; i++) {
        if (cs[i] == ' ') {
            // 将 /2 换成 >>1 直接从 6ms 降到 3ms，book11啊
            for (int j = is, k = 0; j < is + ((i - is) >> 1); j++, k++) {
                char c = cs[j];
                cs[j] = cs[i - k - 1];
                cs[i - k - 1] = c;
            }
            is = i + 1;
        }
    }
    return new String(cs, 0, cs.length - 1);
}
```



**复杂度分析：**
$$
\begin{cases} 时间复杂度：O(nm),\quad n为字符串总长度，m为最长单词长度\\空间复杂度：O(n)，\quad 额外使用了字符数组用来保存字符串的分解 \end{cases}
$$


