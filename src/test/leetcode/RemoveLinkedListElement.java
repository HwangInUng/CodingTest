package test.leetcode;

public class RemoveLinkedListElement {
	public ListNode removeElements(ListNode head, int val) {
		// 문제
		// 링크드 리스트에서 특정 value를 가진 노드를 제거한 결과를 반환

		// 고려 사항
		// list는 0~10,000의 범위
		// 각 node의 value는 1~50의 범위
		// 매개변수로 전달되는 value는 0~50의 범위

		// 문제 해결
		// head가 null인 경우 head 반환
		// val이 0인 경우 head 반환
		// 각 노드의 next.val을 확인하고,
		// val과 같은 경우 next.next가 null이 아니면 현재 노드의 next로 대입
		// null이면 head반환

		if (head == null) {
			return head;
		}

		if (val == 0) {
			return head;
		}

		ListNode result = new ListNode();
		ListNode temp = result;
		while(head != null) {
			if(head.val != val) {
				temp.next = head;
				temp = temp.next;
			}

			if(head.val == val && head.next == null) {
				temp.next = null;
			}

			head = head.next;
		}

		return result.next;
	}
}
