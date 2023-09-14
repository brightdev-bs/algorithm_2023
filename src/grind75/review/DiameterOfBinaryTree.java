package grind75.review;

public class DiameterOfBinaryTree {

    class Solution {
        int answer = 0;
        public int diameterOfBinaryTree(BalancedBinaryTree.TreeNode root) {
            helper(root);
            return answer;
        }

        public int helper(BalancedBinaryTree.TreeNode root) {
            if(root == null) return 0;
            int left = helper(root.left);
            int right = helper(root.right);
            answer = Math.max(answer, left + right);
            return 1 + Math.max(left, right);
        }
    }
}
