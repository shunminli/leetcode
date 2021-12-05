/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean findPath(TreeNode root, TreeNode p, Deque<TreeNode> path) {
        if (root == null) {
            return false;
        }
        
        path.addLast(root);
        if (root.val == p.val) {
            return true;
        }
        if (findPath(root.left, p, path)) {
            return true;
        }
        if (findPath(root.right, p, path)) {
            return true;
        }
        
        path.removeLast();
        return false;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> pPath = new LinkedList<>();
        Deque<TreeNode> qPath = new LinkedList<>();
        findPath(root, p, pPath);
        findPath(root, q, qPath);
        
        TreeNode result = null;
        while (pPath.peekFirst() == qPath.peekFirst() && pPath.peekFirst() != null) {
            result = pPath.peekFirst();
            pPath.removeFirst();
            qPath.removeFirst();
        }
        
        return result;
    }
}