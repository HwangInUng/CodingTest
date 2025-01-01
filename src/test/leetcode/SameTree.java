package test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SameTree {
    // 내가 푼 방식

    // 각 트리의 요소를 각 리스트에 담고, 반복을 통해 동일 여부 확인
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        boolean result = true;

        recursive(list1, p);
        recursive(list2, q);

        for (int i = 0; i < list1.size(); i++) {
            // null로 처리된 경우는 비교 연산 시 false로 처리 되기 때문에 10001로 처리
            int n1 = list1.get(i) == null ? 10001 : list1.get(i);
            int n2 = list2.get(i) == null ? 10001 : list2.get(i);

            if (n1 != n2) {
                result = false;
                break;
            }
        }

        return result;
    }

    public void recursive(List<Integer> list, TreeNode node) {
        if (node == null) {
            list.add(null);
            return;
        }
        list.add(node.val);

        recursive(list, node.left);
        recursive(list, node.right);
    }

    // 다른 사람이 푼 방식
    public boolean isSameTreeBySomeone(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }

            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else if (p == null && q == null) {
            return true;
        } else {
            return false;
        }
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
