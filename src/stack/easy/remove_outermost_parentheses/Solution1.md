> **思路1：**
>
> 使用栈：扫描字符串，若扫描到为 **左括号** **'('** ，则入栈，且如果当前栈不为空，说明该 **左括号** 不是最外层的，则在结果中添加 **左括号 '('**；若扫描到为 **右括号 ')'**，则出栈，出栈后若栈不为空，说明刚出栈的 **右括号 ')'** 不是最外层的，则在结果中添加一个 **右括号 ')'**。

> **参考代码：**

```java
public String removeOuterParentheses(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    StringBuilder res = new StringBuilder();
    for (char c : s.toCharArray()) {
        if (c == '(') {
            if (stack.size() > 0) {
                res.append(c);
            }
            stack.push(c);
        } else {
            stack.pop();
            if (stack.size() > 0) {
                res.append(c);
            }
        }
    }
    return res.toString();
}
```

