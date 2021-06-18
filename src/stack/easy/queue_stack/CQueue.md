# [剑指 Offer 09. 用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)(简单)

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

> **示例 1：**
>
> 输入：
> ["CQueue","appendTail","deleteHead","deleteHead"]
> [[],[3],[],[]]
> 输出：[null,null,3,-1]

> **示例 2：**
>
> 输入：
> ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
> [[],[],[5],[2],[],[]]
> 输出：[null,-1,null,null,5,2]

> **提示：**
>
> 1 <= values <= 10000
> 最多会对 appendTail、deleteHead 进行 10000 次调用



> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

> **参考代码：与 MyQueue 类似，更简单些**

```java
public class CQueue {
    Deque<Integer> stack=new ArrayDeque<>();
    Deque<Integer> temp=new ArrayDeque<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        // 弹出栈为空则把添加栈的元素全部倒腾过来
        if(temp.isEmpty()){
            while(!stack.isEmpty()){
                temp.push(stack.pop());
            }
        }
        return temp.isEmpty()?-1:temp.pop();
    }
}
```

