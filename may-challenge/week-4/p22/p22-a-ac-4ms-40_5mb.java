class Solution {
    public String frequencySort(String s) {
        
        int[] map = new int[255];
        
        char[] c = s.toCharArray();
        
        for (int i = 0; i < c.length; i++) {
            map[c[i]]++;
        }
        
        PriorityQueue<LetterFrequency> pq = new PriorityQueue<>((o1, o2) -> {
            return o2.freq - o1.freq;
        });
        
        for (int i = 0; i < 255; i++) {
            if (map[i] == 0) continue;
            
            pq.add(
                new LetterFrequency((char)i, map[i])
            );
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (pq.isEmpty() == false) {
            LetterFrequency lf = pq.poll();
            
            for (int i = 0; i < lf.freq; i++) {
                sb.append(lf.c);
            }
        }
        
        return sb.toString();
    }
    
    class LetterFrequency {
        public char c;
        public int freq;
        
        public LetterFrequency(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
    
}