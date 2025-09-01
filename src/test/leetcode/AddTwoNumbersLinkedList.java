package test.leetcode;

public class AddTwoNumbersLinkedList {
	public ListNode addTwoNumbers (ListNode l1, ListNode l2) {
		// 문제
		// 서로 다른 정수로 이루어진 링크드 리스트가 주어짐
		// 링크드 리스트를 순차적으로 더한 값을 반환
		// 만약 10이 넘는 경우 올림 숫자를 다음 연산에 포함
		// 두 개의 리스트가 모두 null이 될 때까지 연산 수행
		// 만약, 두 개의 리스트 요소가 모두 1개이고, 합이 10이 넘는 경우 다음 연산에 올림한 숫자를 반환
		ListNode result = new ListNode();
		ListNode temp = result;
		int carry = 0;

		while (true) {
			if (l1 == null && l2 == null) {
				break;
			}

			int sum = carry;

			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			carry = sum / 10;
			sum = sum % 10;

			temp.next = new ListNode(sum);
			temp = temp.next;
		}

		if (carry > 0) {
			temp.next = new ListNode(carry);
		}

		return result.next;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode () {
		}

		ListNode (int val) {
			this.val = val;
		}

		ListNode (int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
