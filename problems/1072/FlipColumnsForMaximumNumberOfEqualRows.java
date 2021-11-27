class Solution {
    
    class Node {
        private int dep;
        private int count;
        private Node nodes[]; // 0 or 1
        
        public Node(int dep) {
            this.dep = dep;
            this.nodes = new Node[2];
        }
        
        public void add(int[] nums) {
            if (dep == nums.length) {
                count++;
                return;
            }
            
            // is same to first num
            int index = nums[0] ^ nums[dep];
            if (nodes[index] == null) {
                nodes[index] = new Node(dep + 1);
            }
            nodes[index].add(nums);
        }
        
        public int getMaxCount() {
            int result = count;
            for (int index = 0; index < 2; index++) {
                if (nodes[index] != null) {
                    result = Math.max(result, nodes[index].getMaxCount());
                }
            }
            return result;
        }
    }
    
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length;
        Node root = new Node(0);
        for (int i = 0; i < n; i++) {
            root.add(matrix[i]);
        }
        
        return root.getMaxCount();
    }
}