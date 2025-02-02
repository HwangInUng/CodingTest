package test.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostorderBinaryTree {
	public List<Integer> postorderTraversal (TreeNode root) {
		// 문제
		// 이진트리를 역순으로 리스트에 저장하여 반환

		// 고려사항
		// 이진 트리는 0~100의 범위를 가짐
		// 각 노드의 값은 -100 ~ 100
		// 재귀 함수가 아닌 반복문으로 해결

		// 문제해결
		// 각 노드를 방문하여 stack에 저장
		// left, right 순으로 null이 아니면 결과 저장
		// 뒤집어서 반환

		if (root == null) {
			return Collections.emptyList();
		}

		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);

			if (node.left != null) {
				stack.push(node.left);
			}

			if (node.right != null) {
				stack.push(node.right);
			}
		}

		Collections.reverse(result);
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
