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
    
    private boolean valid;
    private int index;
    private List<Integer> result;
    
    public void dfs(TreeNode root, int[] voyage) {
        if (root == null) {
            return;
        }
        if (root.val != voyage[index]) {
            valid = false;
            return;
        }
        
        index++;
        if (index < voyage.length && root.left != null && root.left.val != voyage[index]) {
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = tmp;
            result.add(root.val);
        }
        
        dfs(root.left, voyage);
        dfs(root.right, voyage);
    }
    
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        index = 0;
        result = new ArrayList();
        valid = true;
        dfs(root, voyage);
        if (!valid) {
            result = new ArrayList();
            result.add(-1);
        }
        
        return result;
    }
}