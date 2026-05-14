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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);

        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode a = q1.poll();
            TreeNode b = q2.poll();

            if (a == null && b == null) continue;
            else if (a == null || b == null) return false;

            if (a.val != b.val) return false;

            q1.add(a.left);
            q1.add(a.right);
            q2.add(b.left);
            q2.add(b.right);
        }

        return true;
    }
}
