
class RangeFreqQuery {

    // this is a segment tree
    private int startIndexInclusive = 0;
    private int endIndexInclusive = 0;
    private int mid = 0;
    private RangeFreqQuery left = null;
    private RangeFreqQuery right = null;
    private Map<Integer, Integer> countMap = new HashMap<>();
    
    public RangeFreqQuery(int[] arr) {
        this(arr, 0, arr.length - 1);
    }

    public RangeFreqQuery(int[] arr, int startIndexInclusive, int endIndexInclusive) {
        if (arr == null) {
            return;
        }
        
        this.startIndexInclusive = startIndexInclusive;
        this.endIndexInclusive = endIndexInclusive;
        this.mid = (startIndexInclusive + endIndexInclusive) / 2;
        if (startIndexInclusive == endIndexInclusive) {
            // leaf node
            countMap.put(arr[startIndexInclusive], 1);
            return;
        }
        
        if (mid >= startIndexInclusive) {
            this.left = new RangeFreqQuery(arr, this.startIndexInclusive, this.mid);
        }
        if (mid < endIndexInclusive) {
            this.right = new RangeFreqQuery(arr, this.mid + 1, this.endIndexInclusive);
        }
        mergeCountMap(this.left);
        mergeCountMap(this.right);
    }

    public int query(int startIndexInclusive, int endIndexInclusive, int value) {
        if (startIndexInclusive > endIndexInclusive) {
            return 0;
        }

        if (startIndexInclusive == this.startIndexInclusive && endIndexInclusive == this.endIndexInclusive) {
            return countMap.getOrDefault(value, 0);
        }

        int count = 0;
        if (this.left != null) {
            count += this.left.query(startIndexInclusive, Math.min(this.mid, endIndexInclusive), value);
        }
        if (this.right != null) {
            count += this.right.query(Math.max(startIndexInclusive, this.mid + 1), endIndexInclusive, value);
        }

        return count;
    }

    public Map<Integer, Integer> getCountMap() {
        return countMap;
    }

    private void mergeCountMap(RangeFreqQuery rfq) {
        Map<Integer, Integer> countMap = rfq == null ? Collections.emptyMap() : rfq.getCountMap();
        countMap.forEach((k, v) -> {
            // can't import MutableInt -_-
            this.countMap.put(k, v + this.countMap.getOrDefault(k, 0));
        });
    }
}