package test.leetcode;

public class RemoveDuplicatesSortedList {
    // 파라미터 클래스
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        // 문제
        // 정렬된 배열에서 중복된 요소를 제외하고,
        // head를 반환

        // 고려사항
        // LinkedList의 head만 매개변수로 주어짐
        // 정렬된 상태
        // 배열의 길이는 0 ~ 300까지의 범위를 가짐
        // 노드 하나는 -100 ~ 100까지의 범위를 가짐

        // 문제해결
        // 길이가 0이면 head를 반환
        // 반복을 수행하며 현재 노드와 다른 값의 노드가 식별되면
        // next를 변경
        // 현재 노드와 같은 노드의 경우 pass
        // int형의 초기 값은 0이기에 시작을 101 또는 -101로 시작
        // 시간 복잡도는 모든 요소를 순회하는 경우를 고려하여 O(n)
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(101);
        ListNode temp = result;

        while (head != null) {
            if (temp.val != head.val) {
                temp.next = head;
                temp = temp.next;
            }

            head = head.next;
        }

        temp.next = null;

        return result.next;
    }
}
