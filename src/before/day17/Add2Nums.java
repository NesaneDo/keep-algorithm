package before.day17;

import util.ListNode;

public class Add2Nums {
	public static void main(String[] args) {
		Add2Nums add2Nums = new Add2Nums();
		ListNode root = new ListNode();
		ListNode node1 = root.genData(9);
		ListNode node2 = root.genData(1,9,9,9,9,9,9,9,9,9); // 1,9,9,9,9,9,9,9,9,9
		root = add2Nums.addTwoNumbers(node1, node2);
		root.print(root);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0; // 进位
		ListNode head = new ListNode();
		ListNode move = head;
		while (l1 != null || l2 != null) {
			ListNode node=null;
			if (l1 != null && l2 != null) {
				node = new ListNode((l1.val + l2.val + carry) % 10);
				carry = (l1.val + l2.val + carry) / 10;
				l1 = l1.next;
				l2 = l2.next;
			} else if (l1 == null && l2 != null) {
				node = new ListNode((l2.val + carry) % 10);
				carry = (l2.val + carry) / 10;
				l2 = l2.next;
			} else if (l1 != null && l2 == null) {
				node = new ListNode((l1.val+ carry) % 10);
				carry = (l1.val + carry) / 10;
				l1 = l1.next;
			}
			move.next = node;
			move = node;
		}
		if (carry>0) {
			move.next=new ListNode(carry);
		}

		return head.next;
	}
	
	 public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
			StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder(),sum=new StringBuilder();
			while (l1 != null) {
				sb1.append(String.valueOf(l1.val));
				l1=l1.next;
			}
			
			while (l2 != null) {
				sb2.append(String.valueOf(l2.val));
				l2=l2.next;
			}
			int len1=sb1.toString().length();
			int len2=sb2.toString().length();
			String minLenSb=len1>=len2?sb2.toString():sb1.toString(); // 长度更小的那个
			String maxLenSb=len1<len2?sb2.toString():sb1.toString(); // 长度更大的那个
			int carry=0; // 进位
			for(int i=0;i<minLenSb.length();i++){
				int num1=Integer.parseInt(String.valueOf(minLenSb.charAt(i)));
				int num2=Integer.parseInt(String.valueOf(maxLenSb.charAt(i)));
				sum.append((num1+num2+carry)%10);
				carry=(num1+num2+carry)/10;
			}
			for (int i = minLenSb.length(); i <maxLenSb.length(); i++) {
				int num=Integer.parseInt(String.valueOf(maxLenSb.charAt(i)));
				sum.append((num+carry)%10);
				carry=(carry+num)/10;
			}
			if (carry>0) {
				sum.append(carry);
			}
			String res=String.valueOf(sum);
			ListNode head = new ListNode();
			ListNode move=head;
			for (int i = 0; i <res.length();i++) {
				ListNode node=new ListNode(Integer.parseInt(String.valueOf(res.charAt(i))));
				move.next=node;
				move=node;
			}
			return head.next;
		}

}
