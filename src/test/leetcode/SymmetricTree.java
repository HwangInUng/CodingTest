package test.leetcode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // 문제
        // 이진 트리가 루트를 기준으로 symmetric인지 결과 확인

        // 고려사항
        // 트리는 1~1000개의 범위를 가짐
        // 각 요소는 -100 ~ 100의 범위를 가짐
        // 0도 포함되므로 10001로 null을 대체

        // 문제 해결
        // 부모노드가 모두 null인 경우 true
        // 부모노드 중 하나가 null인 경우 false
        // 부모노드의 value가 다른 경우 false

        if (root == null) return false;

        return recursive(root.left, root.right);
    }

    public boolean recursive(TreeNode leftTop, TreeNode rightTop) {
        if (leftTop == null && rightTop == null) return true;
        if (leftTop == null || rightTop == null) return false;
        if (leftTop.val != rightTop.val) return false;

        return recursive(leftTop.right, rightTop.left) && recursive(leftTop.left, rightTop.right);
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
