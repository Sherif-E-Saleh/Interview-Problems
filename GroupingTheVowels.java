package questions;

public class GroupingTheVowels {
	

	public static ListNode groupVowels (ListNode head){
		ListNode preTemp = head;
		ListNode temp = head.next;
		while(temp != null){
			if(temp.charac == 'a' || temp.charac == 'e' || temp.charac =='o' || temp.charac == 'u' || temp.charac == 'i'){
				preTemp.next = temp.next;
				temp.next = head;
				head = temp;
				temp = preTemp.next;
			}
			else{
				temp = temp.next;
				preTemp = preTemp.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ListNode node1 = new ListNode('c');
		ListNode node2 = new ListNode('a');
		ListNode node3 = new ListNode('d');
		ListNode node4 = new ListNode('e');
		ListNode node5 = new ListNode('o');
		ListNode node6 = new ListNode('b');
		ListNode node7 = new ListNode('i');
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		ListNode test = groupVowels(node1);
		
		while(test != null){
			System.out.println(test.charac);
			test = test.next;
		}

	}

}
