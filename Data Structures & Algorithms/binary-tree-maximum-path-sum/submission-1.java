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
    int pathSum;

    public int maxPathSum(TreeNode root) {
        pathSum = Integer.MIN_VALUE;
        dfs(root);
        return pathSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        int currentMaxPath = root.val;
        currentMaxPath = Math.max(currentMaxPath, root.val + leftSum);
        currentMaxPath = Math.max(currentMaxPath, root.val + rightSum);
        currentMaxPath = Math.max(currentMaxPath, root.val + leftSum + rightSum);
        
        pathSum = Math.max(pathSum, currentMaxPath);

        return Math.max(root.val, Math.max(root.val + leftSum, root.val + rightSum));
    }
}
