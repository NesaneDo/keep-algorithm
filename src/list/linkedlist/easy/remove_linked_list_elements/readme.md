# 题目

#### [203. 移除链表元素](https://leetcode.cn/problems/remove-linked-list-elements/)

难度简单1034收藏分享切换为英文接收动态反馈

给你一个链表的头节点 `head` 和一个整数 `val` ，请你删除链表中所有满足 `Node.val == val` 的节点，并返回 **新的头节点** 。

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2021/03/06/removelinked-list.jpg)

```
输入：head = [1,2,6,3,4,5,6], val = 6
输出：[1,2,3,4,5]
```

**示例 2：**

```
输入：head = [], val = 1
输出：[]
```

**示例 3：**

```
输入：head = [7,7,7,7], val = 7
输出：[]
```

 

**提示：**

- 列表中的节点数目在范围 `[0, 104]` 内
- `1 <= Node.val <= 50`
- `0 <= val <= 50`



# 解法

### 1、使用新链表保存

创建新链表来保存不等于 val 的值

**参考代码：**

```java
 public ListNode removeElements(ListNode head, int val) {
     ListNode nh=new ListNode(),node=nh;
     while(head!=null){
         if(head.val!=val){
             nh.next=new ListNode(head.val);
             nh=nh.next;
         }
         head=head.next;
     }
     return node.next;
 }
```

**复杂度分析：**
$$
\begin{cases}时间复杂度：O(n)，需要遍历所有节点 \\\\ 空间复杂度：O(n)，需要额外的链表来保存节点值\end{cases}
$$


### 2、原地删除

将等于 val 值的节点删除。需要注意的是

**参考代码：**

```java
public ListNode removeElements(ListNode head, int val) {
    while (head != null && head.val == val) {
        head = head.next;
    }
    ListNode node = head, p = head;
    while (node != null) {
        if (node.val == val) {
            p.next = node.next;
        } else {
            p = node;
        }
        node = node.next;
    }
    return head;
}
```

**复杂度分析：**
$$
\begin{cases}时间复杂度：O(n)，需要遍历所有节点 \\\\ 空间复杂度：O(1)，只有额外的2个变量\end{cases}
$$
