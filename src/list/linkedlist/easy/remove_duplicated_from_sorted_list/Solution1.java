package list.linkedlist.easy.remove_duplicated_from_sorted_list;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    /**
     * 使用 ArrayList 记录节点值，再依次遍历，如果已经被记录过则删除些节点，再重头开始
     * 时间复杂度 O(n*m)，n为遍历所有元素花的时间，m为连续相同元素的个数：因为每删除一次，就会从上一次删除的节点开始重新遍历
     *
     * @param head 头节点
     * @return 头节点
     */
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
}
