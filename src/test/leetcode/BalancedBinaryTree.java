package test.leetcode;

public class BalancedBinaryTree {
    class TreeNode {
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

    public boolean isBalanced(TreeNode root) {
        // 문제
        // 주어진 이진 트리의 좌우 균형이 맞는지 확인

        // 고려사항
        // 리프 노드가 null인 경우도 고려
        // 트리의 범위는 0 ~ 5,000
        // 노드의 값은 -10,000 ~ 10,000
        // 0인 경우 true로 간주

        // 문제 해결
        // 좌 우측 중 어느 한쪽의 노드가 null일 경우 다음 depth의 노드가 null이면
        // 같은 depth라고 인식.
        // 즉, 서브 트리 간의 차이가 1이상이면 불균형으로 판단
        if (root == null) {
            return true;
        }


        return recursive(root, 1) != -1;
    }

    public int recursive(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        int leftDepth = recursive(node.left, depth + 1);
        int rightDepth = recursive(node.right, depth + 1);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }

        return Math.max(leftDepth, rightDepth);
    }
}
