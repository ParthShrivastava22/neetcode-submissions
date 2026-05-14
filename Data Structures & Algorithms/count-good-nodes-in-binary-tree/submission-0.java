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
    int good = 0;
    public int goodNodes(TreeNode root) {
        findGood(root, root.val);
        return good;
    }

    private void findGood(TreeNode node, int largest) {
        if (node == null) return;

        if (largest <= node.val) {
            good++;
            largest = node.val;
        }

        findGood(node.left, largest);
        findGood(node.right, largest);
    }
}
