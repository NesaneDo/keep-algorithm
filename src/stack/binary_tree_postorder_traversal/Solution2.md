> 方法2：迭代

首先提下二叉树的三种遍历方式：

1. 先序（前序）遍历：**根 - 左 - 右**
2. 中序遍历：**左 - 根 - 右**
3. 后序遍历：**左 - 右 - 根**

思路：将先序遍历变形： **根 - 右 - 左**，再逆序：**左 - 右 - 根**

先序遍历参考代码：

```java
Deque<TreeNode> stack = new LinkedList<>();
List<Integer> res = new ArrayList<>();
// root 为根节点
while(root != null || !stack.isEmpty()){
    if(root != null){
        stack.push(root);
        res.add(root.val);
        root = root.left;
    }else{
        root = stack.pop();
        root = root.right;
    }
}
```

将上述思路实现到代码中则是：遍历时先遍历 **右子节点**，添加值时采用头插法添加前面，参考代码如下：

```java
Deque<TreeNode> stack = new LinkedList<>();
List<Integer> res = new ArrayList<>();
// root 为根节点
while(root != null || !stack.isEmpty()){
    if(root != null){
        stack.push(root);
        res.add(0,root.val);
        root = root.right;
    }else{
        root = stack.pop();
        root = root.left;
    }
}
```

