import java.util.Stack;

class MinStack {

  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
    this.stack = new Stack<>();
    this.minStack = new Stack<>();
  }

  public void push(int x) {
    stack.push(x);
    if (!minStack.empty() && minStack.peek() < x) {
      minStack.push(minStack.peek());
    } else {
      minStack.push(x);
    }
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}