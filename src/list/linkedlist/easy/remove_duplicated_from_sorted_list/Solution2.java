package list.linkedlist.easy.remove_duplicated_from_sorted_list;

import util.ListNode;

public class Solution2 {
    /**
     * 使用双指针
     *
     * @param head 头节点
     * @return 头节点
     */
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
}
