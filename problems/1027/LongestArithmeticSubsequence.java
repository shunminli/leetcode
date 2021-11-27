class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        int[][] f = new int[nums.length][m*2 + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m*2; j++) {
                f[i][j] = 0;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // i --> j
                int v = nums[i] - nums[j] + m;
                f[j][v] = Math.max(f[j][v], f[i][v] + 1);
                result = Math.max(result, f[j][v]);
            }
        }
        
        return result + 1;
    }
}