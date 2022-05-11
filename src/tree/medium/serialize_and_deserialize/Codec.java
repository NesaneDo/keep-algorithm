package tree.medium.serialize_and_deserialize;

import util.TreeNode;

/**
 * LeetCode 449. Serialize And Deserialize
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 449. Serialize And Deserialize
 * @since 2022/5/11
 */
public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.length() > 0 ? sb.delete(sb.length() - 1, sb.length()).toString() : sb.toString();
    }

    /**
     * 使用前序遍历，用 逗号 分隔
     * @param node 根节点
     * @param sb StringBuilder
     */
    void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val).append(',');
        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    /**
     * 反序列化，记录根节点的值，再分割左子树和右子树的数组
     * @param data 序列化后的字符串
     * @return 反序列化的树
     */
    public TreeNode deserialize(String data) {
        String[] d = data.split(",");
        if (d.length == 0) {
            return null;
        }
        int[] nums = new int[d.length];
        int i = 0;
        for (String s : d) {
            try{
                nums[i++] = Integer.parseInt(s);
            }catch(Exception e){
                return null;
            }
        }
        return bi(nums, 0, nums.length - 1);
    }

    /**
     * 分割数组
     * @param nums 所有数据的数组
     * @param s 子树数组开始位置
     * @param e 子树数组结束位置
     * @return 节点
     */
    TreeNode bi(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int i = s;
        int val = nums[i++];
        TreeNode node = new TreeNode(val);
        // i <= e, 可以遍历到最后一个
        for (; i <= e; i++) {
            if (nums[i] > val) {
                break;
            }
        }
        // 分割左子树
        node.left = bi(nums, ++s, --i);
        // 右子树
        node.right = bi(nums, ++i, e);
        return node;
    }

}
