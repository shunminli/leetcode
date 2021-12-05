class Solution {
    
    class Node {
        private int index; // min index can cover
        private int value;
        
        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    
    public int maximalRectangle(int[] h) {
        int m = h.length;
        Stack<Node> st = new Stack<>();
        int result = 0;
        for (int j = 0; j < m; j++) {
            int index = j;
            while (!st.isEmpty() && st.peek().value >= h[j]) {
                Node node = st.pop();
                int area = (j - node.index) * node.value;
                result = Math.max(result, area);
                index = node.index;
            }
            if (h[j] > 0) {
                st.add(new Node(index, h[j]));
            }
        }
        while (!st.isEmpty()) {
            Node node = st.pop();
            int area = (m - node.index) * node.value;
            result = Math.max(result, area);
        }
        
        return result;
    }
    
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        
        int m = matrix[0].length;
        if (m == 0) {
            return 0;
        }
        
        int[][] h = new int[n][m];
        for (int j = 0; j < m; j++) {
            h[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    h[i][j] = h[i - 1][j] + 1;
                } else {
                    h[i][j] = 0;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, maximalRectangle(h[i]));
        }
                      
        return result;
    }
}