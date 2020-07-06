/**
 * @(#)LRUCache.java, Jul 05, 2020.
 *
 * Copyright 2020 Lillard. All rights reserved. Use is subject to license terms.
 */

import java.util.HashMap;

/**
 * @author Lillard
 */
public class LRUCache {

  private int capacity;

  private int size;

  private Node first;

  private Node last;

  private HashMap<Integer, Node> map;

  private class Node {

    private int key;
    private int value;
    private Node next;
    private Node pre;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.next = null;
      this.pre = null;
    }
  }

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.map = new HashMap<>(capacity);
    this.first = new Node(-1, -1);
    this.last = new Node(-1, -1);
    this.first.next = this.last;
    this.last.pre = this.first;
  }

  public int get(int key) {
    Node node = map.get(key);
    if (node == null) {
      return -1;
    }

    // update linked list
    updateRank(node);
    return node.value;
  }

  public void put(int key, int value) {
    Node node = map.get(key);
    if (node == null) {
      if (++size > capacity) {
        --size;
        if (last.pre == first) {
          return;
        }

        // remove last node when size > capacity
        map.remove(last.pre.key);
        remove(last.pre);
      }

      // insert node & put to map
      insert(node = new Node(key, value));
      map.put(key, node);
    } else {
      node.value = value;
      // update linked list
      updateRank(node);
    }
  }

  private void updateRank(Node node) {
    remove(node);
    insert(node);
  }

  private void remove(Node node) {
    if (node.pre != null) {
      node.pre.next = node.next;
    }

    if (node.next != null) {
      node.next.pre = node.pre;
    }
  }

  private void insert(Node node) {
    node.next = first.next;
    first.next.pre = node;
    first.next = node;
    node.pre = first;
  }
}
