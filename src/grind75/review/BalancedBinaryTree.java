package grind75.review;

import javax.swing.tree.TreeNode;

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

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return helper(root) == -1 ? false : true;
    }

    public int helper(TreeNode node) {
        if(node == null) return 0;

        int left = helper(node.left);
        if(left == -1) return -1;

        int right = helper(node.right);
        if(right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
