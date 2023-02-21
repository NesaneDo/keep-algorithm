package list.linkedlist.easy.remove_linked_list_elements;

import util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
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

    public ListNode removeElements2(ListNode head, int val) {
        ListNode nh = new ListNode(), node = nh;
        while (head != null) {
            if (head.val != val) {
                nh.next = new ListNode(head.val);
                nh = nh.next;
            }
            head = head.next;
        }
        return node.next;
    }
}