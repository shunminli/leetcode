class Solution {
    public void dfs(int num, int n, List<Integer> result) {
        if (num > n) {
            return;
        }
        
        result.add(num);
        for (int i = 0; i < 10; i++) {
            dfs(num * 10 + i, n, result);
        }
    }
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, result);
        }
        
        return result;
    }
}