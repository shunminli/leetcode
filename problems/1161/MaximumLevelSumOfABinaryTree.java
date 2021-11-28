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
    class MutableInt {
        private int value;
        public MutableInt(int value) {
            this.value = value;
        }
        
        public void addValue(int v) {
            value += v;
        }
        
        private int getValue() {
            return value;
        }
    }
    
    public void dfs(TreeNode root, int level, List<MutableInt> levelSum) {
        if (root == null) {
            return;
        }
        
        if (level == levelSum.size()) {
            levelSum.add(new MutableInt(0));
        }
        MutableInt sum = levelSum.get(level);
        sum.addValue(root.val);
        
        dfs(root.left, level + 1, levelSum);
        dfs(root.right, level + 1, levelSum);
    }
    
    public int maxLevelSum(TreeNode root) {
        List<MutableInt> levelSum = new ArrayList<>();
        dfs(root, 0, levelSum);
        int resultLevel = 0;
        for (int i = 1; i < levelSum.size(); i++) {
            int v = levelSum.get(i).getValue();
            if (v > levelSum.get(resultLevel).getValue()) {
                resultLevel = i;
            }
        }
        
        return resultLevel + 1;
    }
}