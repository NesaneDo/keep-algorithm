> **思路1：使用栈**
>
> 遍历字符串，若栈不为空且栈顶元素等当前字符的大小写相反（使用 ascii）的则出栈，否则入栈，当字符串遍历完成后，栈中就是结果的逆序，最后再逆序遍历栈即可。

**参考代码：**

```java
public String makeGood(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    StringBuilder res = new StringBuilder();
    for (char c : s.toCharArray()) {
        if (!stack.isEmpty()&&(stack.peek() == c + 32 || stack.peek() == c - 32)) {
            stack.pop();
        } else {
            stack.push(c);
        }
    }
    Iterator<Character> characterIterator = stack.descendingIterator();
    while (characterIterator.hasNext()){
        res.append(characterIterator.next());
    }
    return res.toString();
}
```

