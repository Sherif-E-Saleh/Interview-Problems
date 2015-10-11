package questions;

public class SwapLinkedListNodes {

	/*
	 * A singly link list and a number ‘K’, swap the Kth node from the start
	 * with the Kth node from the last. Check all the edge cases. 
	 * Sample Input:1->2->3->4->5->6->7->8 and K = 3 
	 * Sample Output : 1->2->6->4->5->3->7->8
	 * 
	 * Sample Input: 1->2->3->4->5->6->7->8 and K = 10 Sample Output: print
	 * error “LIST IS OF LESSER SIZE”.
	 */

	public static int length(ListNode head) {
		int n = 0;
		while (head != null) {
			n++;
			head = head.next;
		}
		return n;
	}

	public static void swapNodes(ListNode head, int offset) {

		int length = length(head);
		if (length == 1 || offset < 1 || offset >= length)
			System.out.println("LIST IS OF LESSER SIZE or Offset is less than 1");
		else if (offset == 1 && length > 1) {
			ListNode temp1 = head;
			while ((temp1.next).next != null) {
				temp1 = temp1.next;
			}
			ListNode temp2 = temp1.next;
			temp1.next = head;
			temp2.next = head.next;
			head.next = null;
			print (temp2);
		}

		else {
			ListNode temp1 = head;
			ListNode temp2 = head;
			ListNode tail = head;

			for (int i = 1; i < offset - 1; i++) {
				tail = tail.next;
				temp1 = temp1.next;
			}

			tail = tail.next;
			tail = tail.next;

			while (tail.next != null) {
				tail = tail.next;
				temp2 = temp2.next;
			}

			ListNode hold1 = temp1.next;
			ListNode hold2 = temp2.next;
			ListNode temp = hold1.next;

			temp1.next = hold2;
			temp2.next = hold1;
			hold1.next = hold2.next;
			hold2.next = temp;
			print(head);
		}
	}
	
	public static void print (ListNode head){
		while(head != null){
			System.out.print(head.val);
			head = head.next;
			if(head!=null)
				System.out.print("->");
		}
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
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;

		swapNodes(node1, 5);

//		System.out.println(node1.next.val);
//		System.out.println(node2.next.val);
//		System.out.println(node6.next.val);
//		System.out.println(node3.next.val);
//		System.out.println(node8.next.val);

	}

}
