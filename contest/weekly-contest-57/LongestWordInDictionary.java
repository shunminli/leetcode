import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lillard
 */
public class LongestWordInDictionary {

    public static class Solution {

        public Solution() {

        }

        private Node answer;

        private class Node {

            private char value;
            private boolean mark;
            private int dep;
            private Node pre;
            private Map<Character, Node> nextNode;

            private Node(char value, int dep, Node pre) {
                this.value = value;
                this.mark = false;
                this.dep = dep;
                this.nextNode = new HashMap<>();
                this.pre = pre;
            }

            public void buildTree(String word) {
                if (word == null || word.length() <= 0) {
                    return;
                }

                this.buildTree(word, 0);
            }

            public void buildTree(String word, int index) {
                if (word.length() == index) {
                    this.mark = true;
                    return;
                }

                char value = word.charAt(index);
                Node next = this.nextNode.computeIfAbsent(value, key -> new Node(value, this.dep + 1, this));
                next.buildTree(word, index + 1);
            }

            public void dfs() {
                if (!this.mark) {
                    return;
                }

                if (answer.dep < this.dep) {
                    answer = this;
                }

                for (char c = 'a'; c <= 'z'; c++) {
                    final Node next = this.nextNode.get(c);
                    if (next != null) {
                        next.dfs();
                    }
                }
            }

            public void buildAnswer(StringBuffer buffer) {
                if (this.dep == 0) {
                    return;
                }

                this.pre.buildAnswer(buffer);

                buffer.append(this.value);
            }
        }

        public String longestWord(String[] words) {
            Node root = new Node('0', 0, null);
            root.mark = true;

            Arrays.stream(words).forEach(root::buildTree);
            answer = root;
            root.dfs();

            if (answer == root) {
                return "";
            } else {
                StringBuffer buffer = new StringBuffer();
                answer.buildAnswer(buffer);
                return buffer.toString();
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestWord(new String[]{"w","wo","wor","worl", "world"}));
        System.out.println(solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
}
