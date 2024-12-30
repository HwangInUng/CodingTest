package test.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 문제
        // 이진 트리의 중위 순회 결과를 반환

        // 고려사항
        // 트리의 범위는 0~100
        // 각 노드의 값은 -100 ~ 100
        // 재귀가 아닌 반복으로 해결 권장

        // 문제해결
        // stack에 방문한 노드 값을 쌓아가며 진행
        // 현재 노드 기준 left를 모두 방문하고, null인 경우 반복문을 중단
        // stack에 쌓인 노드 중 가장 상단 노드를 pop하고 list에 추가
        // 현재 노드의 오른쪽으로 탐색 대상을 변경하여 수행

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // 왼쪽 노드 탐색
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 이전 노드 pop, list에 추가
            current = stack.pop();
            result.add(current.val);

            // 오른쪽 노드로 넘어가서 동일하게 작업 반복
            current = current.right;
        }


        return result;
    }

    // 재귀 방식
    // - left를 먼저 탐색하여 node가 null 이면 return
    // - left가 종료 후 현재 노드의 값을 list에 추가
    // - left와 동일하게 수행
    public void recursive(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }

        recursive(list, node.left);
        list.add(node.val);
        recursive(list, node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
