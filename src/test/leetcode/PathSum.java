package test.leetcode;

public class PathSum {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 문제
        // 이진 트리에서 주어진 합계에 도달하는 path가 있는지 검증

        // 고려사항
        // 트리의 노드 개수는 0~5,000
        // 각 노드와 합계의 범위는 -1,000~1,000
        // root가 널인 경우 false

        // 문제 해결
        // 노드의 left, right가 모두 널이고,
        // targetSum이 0이 되면 결과 true
        // depth 단계마다 targetSum - node.val
        // 마지막 리프노드에서 targetSum - node.val이 0인 경우
        // true
        if (root == null) {
            return false;
        }

        int current = targetSum - root.val;
        if (isLeaf(root) && current == 0) {
            return true;
        }

        if (isLeaf(root)) {
            return false;
        }

        return hasPathSum(root.left, current) || hasPathSum(root.right, current);
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
