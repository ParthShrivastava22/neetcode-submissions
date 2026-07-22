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
    int kth = 0;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        return inOrder(root);
    }

    private Integer inOrder(TreeNode node) {
        if (node == null) return null;

        Integer left = inOrder(node.left);
        if (left != null) return left;

        count--;
        if (count == 0) return node.val;

        return inOrder(node.right);
    }
}
