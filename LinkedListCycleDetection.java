package questions;

public class LinkedListCycleDetection {

	public static boolean isCyclic(ListNode head) {
		ListNode temp1 = head.next;
		boolean cyclic = false;
		while (head != null && temp1 != null) {
			if (temp1 == head) {
				cyclic = true;
				break;
			} else {
				if (temp1.next != null) {
					temp1 = temp1.next;
					if (temp1.next != null)
						temp1 = temp1.next;
					else
						break;
				} else
					break;
				head = head.next;
			}
		}
		return cyclic;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = null;
		
		System.out.println(isCyclic(node1));

	}

}
