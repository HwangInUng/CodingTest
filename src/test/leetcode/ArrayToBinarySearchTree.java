package test.leetcode;

public class ArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 문제
        // 오름차순으로 정렬된 정수형 배열이 주어짐
        // 정수형 배열을 높이가 같은 이진 트리로 변환

        // 고려사항
        // 배열은 이미 정렬된 상태로 존재
        // 배열의 크기는 1~10,000
        // 요소의 값은 -10,000 ~ 10,000
        // 높이가 같은 이진 트리로 변환하는 것

        // 문제 해결
        // 배열을 중간 지점에서 2개로 분할
        // 서브 트리에서 현재 값을 저장하고,
        // left와 right에 좌우 노드를 각각 저장
        // start > end인 경우 null
        return convertTree(nums, 0, nums.length - 1);
    }

    // 내가 푼 방식 : 오답
    public TreeNode recursive(int[] nums, int position) {
        if (position == nums.length / 2 || position > nums.length - 1) {
            return null;
        }
        TreeNode node = new TreeNode(nums[position]);

        node.left = recursive(nums, position * 2 + 1);
        node.right = recursive(nums, position * 2 + 2);

        return node;
    }

    // 답변 참고 방식 : 정답
    public TreeNode convertTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int now = (start + end) / 2;
        TreeNode node = new TreeNode(nums[now]);

        node.left = convertTree(nums, start, now - 1);
        node.right = convertTree(nums, now + 1, end);

        return node;
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
