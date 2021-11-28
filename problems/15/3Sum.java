class Solution {
    
    class Tuple {
        private int a;
        private int b;
        private int c;
        
        public Tuple(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Tuple tuple = (Tuple) o;
            return this.a == tuple.a && this.b == tuple.b && this.c == tuple.c;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
        
        boolean illegal(Map<Integer, Integer> num2Count) {
            int count = (a == c ? 1 : 0) + (b == c ? 1 : 0) + 1; 
            return count > num2Count.getOrDefault(c, 0);
        }
        
        List<Integer> toList() {
            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);
            return list;
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Map<Integer, Integer> num2Count = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            num2Count.put(nums[i], num2Count.getOrDefault(nums[i], 0) + 1);
        }
        
        Set<Tuple> tupleSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = nums[i];
                int b = nums[j];
                if (a > b) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
                
                int c = -a - b;
                if (c < b) {
                    continue;
                }

                Tuple tuple = new Tuple(a, b, c);
                if (tupleSet.contains(tuple)) {
                    continue;
                }
                
                if (tuple.illegal(num2Count)) {
                    continue;
                }

                tupleSet.add(tuple);
                result.add(tuple.toList());
            }
        }
        
        return result;
    }
}