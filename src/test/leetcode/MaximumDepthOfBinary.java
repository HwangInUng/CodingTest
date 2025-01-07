package test.leetcode;

public class MaximumDepthOfBinary {
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

    public int maxDepth(TreeNode root) {
        // 문제
        // 이진 트리의 최대 깊이를 구하는 문제

        // 고려사항
        // 트리의 길이는 0~10,000
        // 노드는 -100 ~ 100까지의 범위를 가짐

        // 문제해결
        // 트리의 좌측과 우측을 각각 순회
        // max에 대한 값 최신화 수행
        // node가 null인 경우 return
        if (root == null) {
            return 0;
        }

        return recursive(root, 1);
    }

    public int recursive(TreeNode node, int depth) {
        if (node == null) {
            return depth - 1;
        }

        return Math.max(recursive(node.left, depth + 1), recursive(node.right, depth + 1));
    }
}
