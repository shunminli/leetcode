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
    class Result {
        private Integer maxValue;
        private Integer minValue;
        private boolean valid;
        
        public Result(boolean valid, Integer maxValue, Integer minValue) {
            this.valid = valid;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
    
    public Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(true, null, null);
        }
        
        Result left = dfs(root.left);
        Result right = dfs(root.right);
        if (!left.valid || !right.valid) {
            return new Result(false, null, null);
        }
        if (left.maxValue != null && left.maxValue >= root.val) {
            return new Result(false, null, null);
        }
        if (right.minValue != null && right.minValue <= root.val) {
            return new Result(false, null, null);
        }
        Result result = new Result(true, root.val, root.val);
        if (left.minValue != null) {
            result.minValue = left.minValue;
        }
        if (right.maxValue != null) {
            result.maxValue = right.maxValue;
        }
        return result;
    }
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return dfs(root).valid;
    }
}