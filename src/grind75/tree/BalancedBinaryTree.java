package grind75.tree;

public class BalancedBinaryTree {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            int answer = helper(root);
            return answer == -1 ? false : true;
        }

        public int helper(TreeNode node) {
            if(node == null) return 0;
            int a = helper(node.left);
            if(a == -1) return -1;
            int b = helper(node.right);
            if(b == -1) return -1;
            if(Math.abs(a - b) > 1) return -1;
            return Math.max(a, b) + 1;
        }
    }
}
