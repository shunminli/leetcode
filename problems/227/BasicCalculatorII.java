class Solution {
    private final char[] ops = new char[]{'+', '-', '*', '/'};
    
    public int doOp(char op, int left, int right) {
        switch (op) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            case '/':
                return left/right;
            default:
                return 0;
        }
    }
    
    public int dfs(String s, int startIndexInclusive, int endIndexExclusive) {
        for (int i = endIndexExclusive - 1; i >= startIndexInclusive; i--) {
            char op = s.charAt(i);
            if (op == '+' || op == '-') {
                return doOp(op, dfs(s, startIndexInclusive, i), dfs(s, i + 1, endIndexExclusive));
            }
        }
        for (int i = endIndexExclusive - 1; i >= startIndexInclusive; i--) {
            char op = s.charAt(i);
            if (op == '*' || op == '/') {
                return doOp(op, dfs(s, startIndexInclusive, i), dfs(s, i + 1, endIndexExclusive));
            }
        }
        
        int value = 0;
        for (int i = startIndexInclusive; i < endIndexExclusive; i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                continue;
            }
            value = value * 10 + c - '0';
        }
        return value;
    }
    
    public int calculate(String s) {
        return dfs(s, 0, s.length());
    }
}