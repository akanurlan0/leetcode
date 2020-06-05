class Solution {
    public String longestWord(String[] words) {
        
        System.out.println('e' > 'h');
        
        Arrays.sort(words, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        
        Trie root = new Trie(false);
        
        char[] max = null;
        
        for (int i = 0; i < words.length; i++) {

            Trie node = root;
            
            char[] c = words[i].toCharArray();
            int len = c.length;
            
            boolean flag = true;
            
            for (int j = 0; j < len - 1; j++) {
                Trie next = node.get(c[j]);
                if (next == null || next.end == false) {
                    flag = false;
                    break;
                }
                
                node = next;
            }
            
            if (flag == false) continue;
            
            node.add(c[len - 1], new Trie(true));
            
            if (max == null || max.length < c.length) {
                max = c;
            } else 
            if (max.length == c.length) {
                for (int j = 0; j < max.length; j++) {
                    if (c[j] < max[j]) {
                        max = c;
                        break;
                    } else
                    if (c[j] > max[j]) {
                        break;
                    }
                }
            }
        }
        
        return String.valueOf(max);
    }
    
    class Trie {
        
        public Trie[] letters;
        public boolean end;
        
        public Trie(boolean end) {
            this.letters = new Trie[26];
            this.end = end;
        }
        
        public Trie get(char c) {
            return letters[c - 97];
        }
        
        public void add(char c, Trie t) {
            letters[c - 97] = t;
        }
    }
}