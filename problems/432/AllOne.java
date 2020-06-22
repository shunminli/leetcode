import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class AllOne {

  private Map<Integer, LinkedHashSet<String>> count2Key;

  private Map<String, Node> key2Count;

  private Node first, last;

  private class Node {

    private int data;

    private Node next;

    private Node pre;

    private Node(int data) {
      this.data = data;
      this.next = null;
      this.pre = null;
    }

    private Node(Node pre, int data, Node next) {
      this.pre = pre;
      this.data = data;
      this.next = next;
    }
  }

  public AllOne() {
    this.count2Key = new HashMap<>();
    this.key2Count = new HashMap<>();
    this.first = new Node(0);
    this.last = new Node(Integer.MAX_VALUE);
    this.first.next = this.last;
    this.last.pre = this.first;
  }

  public void inc(String key) {
    Node node = key2Count.getOrDefault(key, first);
    int count = node.data;

    // insert new count
    key2Count.put(key, findNextNode(node));
    count2Key.computeIfAbsent(count + 1, c -> new LinkedHashSet<>()).add(key);

    // remove origin count
    LinkedHashSet<String> originSet = count2Key.get(count);
    if (originSet != null) {
      originSet.remove(key);
      if (originSet.isEmpty()) {
        count2Key.remove(count);
        removeNode(node);
      }
    }
  }

  public void dec(String key) {
    Node node = key2Count.get(key);
    if (node == null) {
      return;
    }

    int count = node.data;

    if (count == 1) {
      // remove key
      key2Count.remove(key);
    } else {
      // insert new count
      key2Count.put(key, findPreNode(node));
      count2Key.computeIfAbsent(count - 1, c -> new LinkedHashSet<>()).add(key);
    }

    // remove origin count
    LinkedHashSet<String> originSet = count2Key.get(count);
    if (originSet != null) {
      originSet.remove(key);
      if (originSet.isEmpty()) {
        count2Key.remove(count);
        removeNode(node);
      }
    } else {
      throw new IllegalStateException("origin set can not be null");
    }
  }

  public String getMaxKey() {
    int count = last.pre.data;
    LinkedHashSet<String> keySet = count2Key.get(count);
    if (keySet == null) {
      return "";
    }

    return keySet.stream().findFirst().get();
  }

  public String getMinKey() {
    int count = first.next.data;
    LinkedHashSet<String> keySet = count2Key.get(count);
    if (keySet == null) {
      return "";
    }

    return keySet.stream().findFirst().get();
  }

  private Node findNextNode(Node node) {
    if (node.next.data == node.data + 1) {
      return node.next;
    }

    Node insertNode = new Node(node, node.data + 1, node.next);
    node.next.pre = insertNode;
    node.next = insertNode;

    return insertNode;
  }

  private Node findPreNode(Node node) {
    if (node.pre.data == node.data - 1) {
      return node.pre;
    }

    Node insertNode = new Node(node.pre, node.data - 1, node);
    node.pre.next = insertNode;
    node.pre = insertNode;

    return insertNode;
  }

  private void removeNode(Node node) {
    node.pre.next = node.next;
    node.next.pre = node.pre;
  }
}
