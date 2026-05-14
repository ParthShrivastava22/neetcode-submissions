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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return createTree(root, target);
    }

    private TreeNode createTree(TreeNode node, int target) {
        if (node == null) return null;

        TreeNode left = createTree(node.left, target);
        TreeNode right = createTree(node.right, target);
        boolean isLeaf = left == null && right == null;

        if (node.val == target && isLeaf) return null;

        TreeNode newNode = new TreeNode(node.val);
        newNode.left = left;
        newNode.right = right;

        return newNode;
    }
}