package test.leetcode;

public class LinkedListCycle {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
			this.next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		// 문제
		// 링크드 리스트가 순환되는지 여부를 반환

		// 고려사항
		// 링크드 리스트의 길이 0~10,000
		// 각 node의 value -100,000 ~ 100,000
		// pos는 -1 또는 유효한 인덱스지만 파라미터로 주어지지 않음
		// O(1)의 공간 복잡도를 사용하여 문제해결

		// 문제 해결
		// 각 노드의 next가 이전 경로에 있었는지 확인 필요
		// 현재 node가 null이면 false
		// 현재 node의 next.val = 범위를 벗어난 값(Integer.MAX_VALUE)라면 true
		// 각 node 방문시 val 값 업데이트

		if(head == null) {
			return false;
		}

		if(head.val == Integer.MAX_VALUE) {
			return true;
		}

		head.val = Integer.MAX_VALUE;
		return hasCycle(head.next);
	}
}
