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
    public boolean isValidBST(TreeNode root) {
        return validBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean validBST(TreeNode node, int ul, int ll) {
        if (node == null) return true;

        if (node.val >= ul || node.val <= ll) return false;
        else return validBST(node.left, node.val, ll) && 
                    validBST(node.right, ul, node.val);
    }
}
