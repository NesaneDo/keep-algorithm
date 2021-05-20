> 方法 1：递归

递归比较简单：根据 **左 - 右 - 根** 的顺序遍历即可

参考代码：

```java
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res=new ArrayList<Integer>();
    recursive(res,root);
    return res;
}
public void recursive(List<Integer> res,TreeNode root){
    if(root==null){
        return;
    }
    recursive(res,root.left);
    recursive(res,root.right);
    res.add(root.val);
}
```

