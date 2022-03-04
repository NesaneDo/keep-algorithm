> 解法一：遍历报数

从`1`开始依次求结果

**参考代码：**

```java
public String countAndSay(int n) {
    String res = "1";
    if (n == 1) {
        return res;
    }
    for (int i = 1; i < n; i++) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        int len = res.length();
        for (int j = 0; j < len; j++) {
            char c1 = res.charAt(j);
            char c2 = ' ';
            if (j + 1 < len) {
                c2 = res.charAt(j + 1);
            }
            if (c1 == c2) {
                count++;
            } else {
                sb.append(count).append(c1);
                count=1;
            }
        }
        res = sb.toString();
    }
    return res;
}
```

$$
\begin{cases}时间复杂度：O(n \times m)，m为(n-1) 的结果的长度  \\\\ 空间复杂度：O(m)，使用了 StringBuilder 保存中间过程的结果 \end{cases}
$$

