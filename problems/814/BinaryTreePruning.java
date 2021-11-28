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
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        if (left == null && right == null && root.val == 0) {
            return null;
        }
        
        return new TreeNode(root.val, left, right);
    }
}