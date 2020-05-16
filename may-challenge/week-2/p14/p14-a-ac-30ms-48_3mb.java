class Trie {

    public static int SIZE = 26;
    
    public Trie[] children;
    public boolean endOfWord;
    
    /** Initialize your data structure here. */
    public Trie() {
        
        children = new Trie[SIZE];
        endOfWord = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        Trie root = this;
        
        for (int i = 0; i < word.length(); i++) {
            int code = word.charAt(i) - 'a';
            if (root.children[code] == null) {
                root.children[code] = new Trie();                
            }
            root = root.children[code];
        }
        
        root.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            int code = word.charAt(i) - 'a';
            if (root.children[code] == null) {
                return false;              
            }
            root = root.children[code];
        }
        
        return root.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie root = this;
        for (int i = 0; i < prefix.length(); i++) {
            int code = prefix.charAt(i) - 'a';
            if (root.children[code] == null) {
                return false;              
            }
            root = root.children[code];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */