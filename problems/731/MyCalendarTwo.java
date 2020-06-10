/**
 * @author Lillard
 */
class MyCalendarTwo {

  private static final int MAX_VALUE = 1000000000;

  private class TreeNode {

    private int startInclusive;
    private int mid;
    private int endExclusive;
    private int maxValue; // max value from [startInclusive, endExclusive)
    private int lazyDelta; // lazy update

    private TreeNode left;
    private TreeNode right;

    TreeNode(int startInclusive, int endExclusive, int maxValue) {
      this.startInclusive = startInclusive;
      this.endExclusive = endExclusive;
      this.mid = (startInclusive + endExclusive) / 2;
      this.maxValue = maxValue;
      this.lazyDelta = 0;
      this.left = null;
      this.right = null;
    }

    private int findMax(int startInclusive, int endExclusive) {
      if (startInclusive >= endExclusive) {
        return 0;
      }

      if (this.startInclusive == startInclusive && this.endExclusive == endExclusive) {
        return this.maxValue + this.lazyDelta;
      }

      int max = 0;
      if (startInclusive < this.mid) {
        int leftMax = this.getLeft().findMax(startInclusive, Math.min(this.mid, endExclusive));
        max = Math.max(max, leftMax);
      }
      if (endExclusive > this.mid) {
        int rightMax = this.getRight().findMax(Math.max(this.mid, startInclusive), endExclusive);
        max = Math.max(max, rightMax);
      }

      return max + this.lazyDelta;
    }

    private void insert(int startInclusive, int endExclusive) {
      if (startInclusive >= endExclusive) {
        return;
      }

      if (this.startInclusive == startInclusive && this.endExclusive == endExclusive) {
        this.lazyDelta++;
        return;
      }

      // sink lazy delta
      this.sink();

      if (startInclusive < this.mid) {
        this.getLeft().insert(startInclusive, Math.min(this.mid, endExclusive));
      }
      if (endExclusive > this.mid) {
        this.getRight().insert(Math.max(this.mid, startInclusive), endExclusive);
      }

      this.maxValue = Math.max(this.getLeft().maxValue + this.getLeft().lazyDelta,
          this.getRight().maxValue + this.getRight().lazyDelta);
    }

    private void sink() {
      this.getLeft().lazyDelta += this.lazyDelta;
      this.getRight().lazyDelta += this.lazyDelta;

      this.lazyDelta = 0;
    }

    private TreeNode getLeft() {
      if (this.left == null) {
        this.left = new TreeNode(this.startInclusive, this.mid, this.maxValue);
      }

      return this.left;
    }

    private TreeNode getRight() {
      if (this.right == null) {
        this.right = new TreeNode(this.mid, this.endExclusive, this.maxValue);
      }

      return this.right;
    }
  }

  private TreeNode root;

  public MyCalendarTwo() {
    this.root = new TreeNode(0, MAX_VALUE, 0);
  }

  public boolean book(int startInclusive, int endExclusive) {
    if (root.findMax(startInclusive, endExclusive) < 2) {
      root.insert(startInclusive, endExclusive);
      return true;
    } else {
      return false;
    }
  }
}
