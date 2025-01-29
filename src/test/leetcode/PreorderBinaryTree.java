package test.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PreorderBinaryTree {
	public List<Integer> preorderTraversal (TreeNode root) {
		// 문제
		// 이진 트리의 value를 순서에 맞게 반환

		// 고려사항
		// 이진 트리의 수는 0 ~ 100
		// 각 노드의 값은 -100 ~ 100
		// 재귀 호출이 아닌 반복문으로 처리

		// 문제 해결
		// root가 null 이면 빈 리스트 반환
		// Queue를 이용
		// Queue에 최초 root를 저장
		// 자식 노드가 있는 경우 Queue.add()
		// 큐에서 하나씩 꺼내서 자식 노드를 검증 반복

		if (root == null) {
			return Collections.emptyList();
		}

		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		while (root != null) {
			result.add(root.val);

			if (root.right != null) {
				stack.push(root.right);
			}

			root = root.left;
			if (root == null && !stack.isEmpty()) {
				root = stack.pop();
			}
		}

		return result;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode () {
		}

		TreeNode (int val) {
			this.val = val;
		}

		TreeNode (int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
