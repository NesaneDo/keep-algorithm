# [100. 相同的树](https://leetcode-cn.com/problems/same-tree/)(简单)

给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

> 示例 1：
>
> ![](https://nesanedo.github.io/pics_bed_static/img/picbed/algorithm/same_tree/1.jpg)
>
> 输入：p = [1,2,3], q = [1,2,3]
> 输出：true

> 示例 2：
>
> ![](https://nesanedo.github.io/pics_bed_static/img/picbed/algorithm/same_tree/2.jpg)
>
> 输入：p = [1,2], q = [1,null,2]
> 输出：false

> 示例 3：
>
> ![](https://nesanedo.github.io/pics_bed_static/img/picbed/algorithm/same_tree/3.jpg)
>
> 输入：p = [1,2,1], q = [1,1,2]
> 输出：false

**提示：**

**两棵树上的节点数目都在范围 [0, 100] 内**
**-104 <= Node.val <= 104**

> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/same-tree
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。