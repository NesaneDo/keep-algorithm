> 解法一：使用ArrayList记录不同的节点

对所有节点进行遍历，使用一个ArrayList记录遍历过的，在加入节点值的时候判断这个值是否存在于ArrayList，如果存在则删除该节点，再重新开始遍历

**参考代码：**

```java
public ListNode deleteDuplicates(ListNode head) {
    if (null == head) {
        return head;
    }
    List<Integer> keys = new ArrayList<>();
    ListNode node = head, pre = head;
    while (null != node) {
        if (keys.contains(node.val)) {
            pre.next = node.next;
            node = pre;
        } else {
            keys.add(node.val);
        }
        pre = node;
        node = node.next;
    }
    return head;
}
```

$$
\begin{cases} 时间复杂度：O(n*m)，n为遍历所有元素花的时间，m为连续相同元素的个数\\\\ 空间复杂度：O(n)，需要保存所有不同的值 \end{cases}
$$





> 解法二：使用双指针

遍历节点，记录开始遍历节点 **pre**，如果当前节点 **cur** 的值不等于 **pre** 的值，则将 **pre.next** 指向当前节点，如果到结尾了，cur 的值一直等于 pre 的值，则说明最后一段节点的值都相等，则将 **pre.next** 指向 **null**。

**参考代码：**

```java
public ListNode deleteDuplicates(ListNode head) {
    if (null == head) {
        return null;
    }
    ListNode pre = head, cur = head.next;
    while (cur != null) {
        if (pre.val != cur.val) {
            pre.next = cur;
            pre = cur;
        }
        cur = cur.next;
        if(cur==null){
            pre.next=null;
        }
    }
    return head;
}
```

$$
 \begin{cases} 时间复杂度：O(n)，遍历所有元素\\\\ 空间复杂度：O(1)，只有两个 ListNode 的变量 \end{cases}
$$