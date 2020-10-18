class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Item> pq = new PriorityQueue<>((a, b) -> b.value - a.value);
        Map<Integer, Item> map = new HashMap<>();
        
        for (int n : nums) {
            if (map.containsKey(n)) {
                Item item = map.get(n);
                pq.remove(item);
                item.count++;
                pq.add(item);
            } else {
                Item item = new Item(n, 1);
                map.put(n, item);
                pq.add(item);
            }
        }
        
        int counter = k;
        while (true) {
            Item item = pq.poll();
            if (counter - item.count > 0) {
                counter -= item.count;
            } else {
                return item.value;
            }
        }
    }
    
    class Item {
        int value;
        int count;
        
        Item(int v, int c) {
            value = v;
            count = c;
        }
    }
}