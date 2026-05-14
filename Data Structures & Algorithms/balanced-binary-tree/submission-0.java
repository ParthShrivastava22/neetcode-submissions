/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        getHeight(root);
        return balanced;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        int diff = left - right;

        balanced = (balanced) ? (diff <= 1 && diff >= -1) : false;

        return 1 + Math.max(left, right);
    }
}
