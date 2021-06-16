> 思路2：使用栈

虽然它不是后缀表达式，但是可以像后缀表达式那样来操作

> 步骤：

1. 遍历数组，判断各操作符
2. 若当前为数字，直接入栈（可以用一个变量 sum 来直接保存中间的结果，最后返回 sum 即可，少去最后遍历 栈 的步骤）
3. 若当前为 "+"，取栈顶的两个元素进行相加，然后把相加的值压入栈（这里需要注意，只用 pop() 一次，即栈顶，把栈顶元素保存下来，再取一次 peek()，不用 pop() 两次），再用 sum 与栈顶元素相加
4. 若当前为 "C"，直接出栈，并用 sum - 去出栈的值
5. 若当前为 "D"，取栈顶元素 peek()*2，再入栈，用 sum 与 入栈元素相加
6. 返回 sum

**时间复杂度: O(n)**  
**空间复杂度: O(n)**  

> 参考代码

```java
public int calPoints(String[] ops){
        Deque<Integer> stack = new LinkedList<>();
        int sum=0;
        for (String n:ops){
            // 判断操作符和数字
            switch (n){
                case "+":
                    // 这里需要弹出一个，然后又把它装回去
                    int peek1=stack.pop();
                    int afterPeek=stack.peek();
                    stack.push(peek1);
                    stack.push(peek1+afterPeek);
                    sum+=stack.peek();
                    break;
                case "C":
                    sum-=stack.pop();
                    break;
                case "D":
                    int numd=stack.peek()*2;
                    stack.push(numd);
                    sum+=numd;
                    break;
                default:
                    int num=Integer.parseInt(n);
                    stack.push(num);
                    sum+=num;
                    break;
            }
        }
        return sum;
    }
```