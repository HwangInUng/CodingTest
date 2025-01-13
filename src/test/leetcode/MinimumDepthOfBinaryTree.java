package test.leetcode;

public class MinimumDepthOfBinaryTree {
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

    public int minDepth(TreeNode root) {
        // 문제
        // root 노드를 기준으로 리프 노드까지의 최단거리를 반환

        // 고려사항
        // 첫 시작의 left, right 중 null인 경우 거리 포함 x
        // 좌우측의 마지막 노드가 살아있는 경우 계속해서 계산
        // 최단거리에 대한 값을 반환
        // 트리의 범위는 0 ~ 100,000
        // 각 노드의 값은 -1,000 ~ 1,000

        // 문제 해결
        // root가 null 인 경우 0 반환
        // depth가 1이고, left, right 중 null이면 MAX_VALUE
        // 트리의 좌우측의 null 여부를 재귀 호출로 판단
        // 좌우측 모두 null인 경우 현재 depth 반환
        // Math.min을 통해 좌우측의 depth 중 가장 짧은 depth 적용

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(recursive(root.left, 1, false), recursive(root.right, 1, false));
    }

    public int recursive(TreeNode node, int depth, boolean isLeaf) {
        if (isLeaf) {
            return depth;
        }

        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.left == null && node.right == null) {
            isLeaf = true;
        }

        return Math.min(recursive(node.left, depth + 1, isLeaf), recursive(node.right, depth + 1, isLeaf));
    }
}
