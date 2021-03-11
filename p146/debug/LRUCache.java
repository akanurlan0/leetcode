import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class LRUCache {

    public static void main(String[] args) {

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // evicts key 2
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // evicts key 1
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

    private int capacity;
    private int counter;
    
    private Map<Integer, Integer> mapValue;
    private Map<Integer, LRUKey> mapKey;
    private PriorityQueue<LRUKey> pq;
    
    public LRUCache(int c) {
        capacity = c;
        counter = 0;
        mapValue = new HashMap<Integer, Integer>();
        mapKey = new HashMap<Integer, LRUKey>();
        pq = new PriorityQueue<LRUKey>(capacity, (a, b) -> a.weight - b.weight);
    }
    
    public int get(int key) {
        if (mapKey.containsKey(key)) {

            LRUKey previousLruKey = mapKey.get(key);
            pq.remove(previousLruKey);

            LRUKey newLruKey = new LRUKey(key, counter++);
            pq.add(newLruKey);

            mapKey.put(key, newLruKey);

            return mapValue.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        if (mapKey.containsKey(key)) {
            
            LRUKey previousLruKey = mapKey.get(key);
            pq.remove(previousLruKey);
            
            LRUKey newLruKey = new LRUKey(key, counter++);
            pq.add(newLruKey);
            
            mapValue.put(key, value);
            mapKey.put(key, newLruKey);
        } else {
            
            if (pq.size() == capacity) {
                LRUKey lruKeyToRemove = pq.poll();
                int keyToRemove = lruKeyToRemove.key;
                mapKey.remove(keyToRemove);
                mapValue.remove(keyToRemove);
            }
            
            LRUKey newLruKey = new LRUKey(key, counter++);
            pq.add(newLruKey);
            
            mapValue.put(key, value);
            mapKey.put(key, newLruKey);
        }
    }
    
    class LRUKey {
        
        final int key;
        final int weight;
        
        LRUKey(int k, int w) {
            key = k;
            weight = w;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + weight + ")";
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */