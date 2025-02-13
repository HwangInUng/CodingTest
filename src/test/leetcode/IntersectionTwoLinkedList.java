package test.leetcode;

import java.util.HashSet;

public class IntersectionTwoLinkedList {
	public class ListNode {
		int val;
		ListNode next;
		public ListNode() {}
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// 문제
		// 두 개의 링크드 리스트에서 교차되는 노드를 반환

		// 고려사항
		// 교차되는 노드를 비교
		// 리스트의 길이는 1 ~ 30,000
		// 노드의 값은 1 ~ 100,000
		// 시간 복잡도 : O(m + n) 각 1번씩 반복
		// 공간 복잡도 : O(1)

		// 문제해결
		// 중복되는 노드를 비교하기 위해 set을 이용
		// 값을 비교하는게 아닌 참조를 비교
		// 1번 케이스의 경우 값이 1로 동일하더라도 교차하지 않는 것으로 판단
		// 각 리스트의 원형을 유지하기 위해 임시 객체를 이용
		HashSet<ListNode> set = new HashSet<>();
		ListNode temp = headA;

		while (temp != null) {
			set.add(temp);
			temp = temp.next;
		}

		temp = headB;
		while (temp != null) {
			if(set.contains(temp)) {
				return temp;
			}
			temp = temp.next;
		}

		return null;
	}
}
