class Solution {
    
    public void dfs(String[][] subStr, Set<String> wordSet, int n, int i, String s, List<String> result) {
        if (i >= n) {
            result.add(s);
            return;
        }
        
        for (int j = i; j < n; j++) {
            if (wordSet.contains(subStr[i][j])) {
                dfs(subStr, wordSet, n, j + 1, s + " " + subStr[i][j], result);
            }
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        String[][] subStr = new String[n][n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                sb.append(s.charAt(j));
                subStr[i][j] = sb.toString();
            }
        }
        
        List<String> result = new ArrayList();
        Set<String> wordSet = wordDict.stream()
            .collect(Collectors.toSet());
        
        for (int j = 0; j < n; j++) {
            if (wordSet.contains(subStr[0][j])) {
                dfs(subStr, wordSet, n, j + 1, subStr[0][j], result);
            }
        }

        return result;
    }
}