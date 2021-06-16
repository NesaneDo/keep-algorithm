> 思路2：使用栈，其实和 思路1 很类似，不过是把 StringBuilder 换成了栈，其实速度还没 StringBuilder 快

> 具体步骤

使用两个 **栈** 保存退格后的字符串，后面再比较
1. 遍历两个字符串，若当前为字母，直接入到对应的栈中
2. 若当前为 '#'，判断对应栈是否为空，不为空则出栈
3. 遍历完成后，先判断下两个栈的长度是否相等，不相等直接返回 false，做这一步其实是必要的，因为要依次出栈
4. 两个栈依次出栈，并判断出栈元素是否相等，不相等直接返回 false
5. 出栈完，即程序运行到最后才返回 true

> 复杂度分析

**时间复杂度: O(n)**  
**空间复杂度: O(n)** 

> 参考代码

```java
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> src = new LinkedList<>();
        Deque<Character> target = new LinkedList<>();
        getBackStack(s, src);
        getBackStack(t, target);
        if (src.size() != target.size()) {
            return false;
        }
        while (!src.isEmpty()) {
            if (!src.pop().equals(target.pop())) {
                return false;
            }
        }
        return true;
    }

    private void getBackStack(String t, Deque<Character> target) {
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (!target.isEmpty()) {
                    target.pop();
                }
            } else {
                target.push(c);
            }
        }
    }
```