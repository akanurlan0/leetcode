class RandomizedSet {

    private HashMap<Integer, Integer> map;
    private List<Integer> list;
    private List<Range> ranges;
    private Random random;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        ranges = new ArrayList<>();
        ranges.add(new Range(0, 0));
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        
        int pos = list.size();
        list.add(val);
        
        map.put(val, pos);
        if (ranges.size() == 0) {
            ranges.add(new Range(pos, pos));
        } else {
            ranges.get(ranges.size() - 1).r = pos;
        }
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        
        int pos = map.get(val);
        
        Range old = null;
        int oldIndex = 0;
        for (int i = 0; i < ranges.size(); i++) {
            if (ranges.get(i).contains(pos)) {
                oldIndex = i;
                old = ranges.get(i);
                break;
            }
        }
        
        if (old.l < pos) {
            ranges.add(new Range(old.l, pos - 1));
        }
        if (pos < old.r) {
            ranges.add(new Range(pos + 1, old.r));
        }
        ranges.remove(oldIndex);
        
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int total = map.size();
        int rand = random.nextInt(total);
        
        int index = 0;
        
        for (int i = 0; i < ranges.size(); i++) {
            if (rand - ranges.get(i).size() >= 0) {
                rand -= ranges.get(i).size();
            } else {
                index = i;
                break;
            }
        }
        
        return list.get(ranges.get(index).l + rand);
    }
    
    class Range {
        public int l, r; // left inclusive, right inclusive
        
        public Range(int l, int r) {
            this.l = l;
            this.r = r;
        }
        
        public boolean contains(int p) {
            return l <= p && p <= r;
        }
        
        public int size() {
            return r - l + 1;
        }
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */