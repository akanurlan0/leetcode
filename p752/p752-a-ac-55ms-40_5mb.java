class Solution {
    public int openLock(String[] ds, String ts) {
        
        int[] deadends = new int[ds.length];
        for (int i = 0; i < ds.length; i++) {
            deadends[i] = Integer.parseInt(ds[i]);
        }
        
        if (isDeadend(deadends, 0)) return -1;
        
        int target = Integer.parseInt(ts);
        
        int[] digitActions = { -1, 1 };
        
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        
        queue.add(0);
        
        int step = 0;
        
        int[] arr = new int[4];
        
        while (queue.peek() != null) {
            
            int size = queue.size();
            step++;
            
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                
                arr[0] = curr           / 1000;
                arr[1] = (curr % 1000)  / 100;
                arr[2] = (curr % 100)   / 10;
                arr[3] = (curr % 10);
                
                for (int j = 0; j < 4; j++) {
                    int sourceDigit = arr[j];
                    
                    for (int k = 0; k < digitActions.length; k++) {
                        arr[j] = sourceDigit + digitActions[k];
                        if      (arr[j] == -1) arr[j] = 9; 
                        else if (arr[j] == 10) arr[j] = 0;
                        
                        int next = assemble(arr[0], arr[1], arr[2], arr[3]);
                    
                        if (visited.contains(next)) {
                            continue;
                        }
                        
                        if (isDeadend(deadends, next)) {
                            continue;
                        }
                        
                        if (next == target) return step;
                        
                        queue.add(next);
                        visited.add(next);
                    }
                    
                    arr[j] = sourceDigit;
                }
            }
        }
        
        return -1;
    }
    
    private boolean isDeadend(int[] deadends, int curr) {
        for (int i = 0; i < deadends.length; i++) {
            if (deadends[i] == curr) return true;
        }
        return false;
    }
    
    private int assemble(int a, int b, int c, int d) {
        return (a * 1000) + (b * 100) + (c * 10) + d;
    }
}