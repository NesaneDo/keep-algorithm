> **思路2：**使用计数器
>
> 初始化一个为 **0** 的计数器 **count**。
>
> 扫描字符串，若当前扫描到 **左括号 '('**，则计数器 **count+1**，若 **count > 1**，说明该 **左括号** 不是最外层的则在结果中添加一个 **左括号 '('**；
>
> 若当前扫描到 **右括号 ')'**，则计数器 **count-1**，若 **count > 2**，说明该 **右括号** 不是最外层的，则在结果中添加一个 **右括号 ')'**。

> **参考代码**：

```java
public String removeOuterParentheses(String s) {
    StringBuilder res=new StringBuilder();
    int count=0;
    for(char c:s.toCharArray()){
        if((c=='('&&count++>0)||(c==')'&&count-->1)){
            res.append(c);
        }
    }
    return res.toString();
}
```

