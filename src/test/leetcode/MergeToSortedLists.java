package test.leetcode;


public class MergeToSortedLists {
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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 문제
        // 두 개의 오름차순으로 정렬된 리스트가 주어짐
        // 리스트를 병합 정렬을 해야하며,
        // 링크드 리스트 방식으로 노드 간의 참조를 연결
        // 병렬되었을 때 2개의 리스트 중 첫 번째 노드가
        // 위치한 리스트를 반환

        // 고려사항
        // 리스트의 길이는 0에서 최대 50
        // 각 노드의 value는 -100에서 100
        // 내림차순으로 정렬할 순 없음
        // 두 노드의 길이가 동일하다고 보장할 수 없음

        // 문제해결
        // 두 리스트의 길이가 다를 수 있다고 가정
        // 두 node가 null이 되는 경우까지 반복수행
        // 비교 대상 중 작은 갚을 next로 지정 후
        // 해당 리스트만 다음 요소로 이동
        // 위 작업을 반복문 종료까지 수행
        // 반복문 종료 후
        // 둘중에 null이 아닌 노드를 추가

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode result = new ListNode();
        // head 이후에 추가될 노드를 저장
        ListNode temp = result;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                temp.next = list2;
                list2 = list2.next;
            } else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }

        if (list1 == null)
            temp.next = list2;
        else
            temp.next = list1;

        return result.next;
    }
}
