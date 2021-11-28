class Solution {
    public int findMaxLength(int[] nums) {
        // change 0 to -1
        Map<Integer, Integer> sum2MinIndex = new HashMap<>();
        int sum = 0;
        int result = 0;
        sum2MinIndex.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }
            Integer preIndex = sum2MinIndex.get(sum);
            if (preIndex == null) {
                sum2MinIndex.put(sum, i);
            } else {
                result = Math.max(result, i - preIndex);
            }
        }
        
        return result;
    }
}