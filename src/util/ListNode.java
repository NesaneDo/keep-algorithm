package util;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public void print(ListNode root) {
		while (root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
	}
	public void print() {
		ListNode root=this;
		while (root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
		System.out.println();
	}

	public ListNode genData(int... nums) {
		ListNode head = new ListNode();
		ListNode move=head;
		for (int i = 0; i < nums.length; i++) {
			ListNode node= new ListNode(nums[i]);
			move.next=node;
			move=node;
		}
		return head.next;
	}

}
