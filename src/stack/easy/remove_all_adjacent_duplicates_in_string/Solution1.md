> **思路1：**使用栈
>
> 遍历字符串，若栈不为空，且当前遍历到的字符与栈顶元素相同，则出栈。字符串遍历完成后，栈中保存的就是答案的逆序，再次逆序遍历即可。

> **参考代码：**

```java
public String removeDuplicates(String s) {
    Deque<Character> stack=new ArrayDeque<Character>();
    StringBuilder res=new StringBuilder();
    for(char c:s.toCharArray()){
        // 栈不为空并且栈顶元素和当前元素相同，则出栈
        if(!stack.isEmpty()&&stack.peek()==c){
            stack.pop();
        }else{
            stack.push(c);
        }
    }
    // 遍历完成后，栈中剩下的元素就是结果的逆序，需要逆序遍历
    Iterator<Character> iterator=stack.descendingIterator();
    while(iterator.hasNext()){
        res.append(iterator.next());
    }
    return res.toString();
}
```

