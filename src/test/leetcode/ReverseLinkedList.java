package test.leetcode;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		// 문제
		// 링크드 리스트를 reverse 한 결과를 반환

		// 고려사항
		// 노드의 개수는 0~5,000
		// 각 노드의 val은 -5,000~5,000

		// 문제해결
		// head가 null이 될 때까지 반복문 수행
		// 반복문 안에서 해당 노드의 다음 노드를 임시로 저장
		// 현재 노드가 바라보는 방향을 이전 노드로 전환
		// 이전 노드를 현재 노드로 치환
		// 현재 노드는 반복문안에서 임시 저장한 다음 노드로 대입
		// 최종적으로 이전 노드를 반환하면 거꾸로 전환된 링크드 리스트 반환

		ListNode prev = null;

		while(head != null) {
			ListNode next = head.next;
			head.next = prev;

			prev = head;
			head = next;
		}

		return prev;
	}
}
