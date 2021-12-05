class Solution {
    
    class Node {
        private int index; // min index can cover
        private int value;
        
        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    
    public int largestRectangleArea(int[] h) {
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
}