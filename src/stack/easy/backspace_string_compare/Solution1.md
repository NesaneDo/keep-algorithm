> 思路1：将两个字符串按照要求退格后再比较，用 StringBuilder

>具体步骤：  

使用两个 StringBuilder 保存退格后的字符串，后面再比较
1. 遍历两个字符串，若当前为字母，直接添加到对应 StringBuilder 中
2. 若当前为 '#'，判断 StringBuilder 中是否存在字母，存在则删除最后一个
3. 比较两个 StringBuilder 中的内容是否相等

> 复杂度分析

**时间复杂度: O(n)**  
**空间复杂度: O(n)** 

> 参考代码

```java
    public boolean backspaceCompare(String s, String t) {
        StringBuilder src = new StringBuilder();
        StringBuilder target = new StringBuilder();
        getBackString(s, src);
        getBackString(t, target);
        return src.toString().equals(target.toString());
    }

    private void getBackString(String t, StringBuilder target) {
        for (char c : t.toCharArray()) {
            int len = target.length();
            if (c == '#') {
                if (len > 0) {
                    target.deleteCharAt(len - 1);
                }
            } else {
                target.append(c);
            }
        }
    }
```