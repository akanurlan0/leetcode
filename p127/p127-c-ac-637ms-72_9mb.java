class Solution {
    
    private String beginWord, endWord;
    private String[] l;
    private int n;
    private boolean[][] p;
    private int pathMin;
    private int destIndex;
    
    private int[] dist;
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        this.beginWord = beginWord;
        this.endWord = endWord;
        
        l = new String[wordList.size() + 1];
        for (int i = 0; i < wordList.size(); i++) {
            l[i] = wordList.get(i);
        }
        l[wordList.size()] = beginWord;
        n = l.length;
        
        destIndex = -1;
        for (int i = 0; i < n; i++) {
            if (l[i].equals(endWord)) {
                destIndex = i;
            }
        }
        if (destIndex == -1) {
            return 0;
        }

        int wl = beginWord.length();
        
        p = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                
                int k = 0;
                
                int failCounter = 0;
                while (k < wl) {
                    if (l[i].charAt(k) != l[j].charAt(k)) {
                        failCounter++;
                        if (failCounter > 1) {
                            break;
                        }
                    }
                    k++;
                }
                
                if (failCounter == 1) {
                    p[i][j] = true;
                    p[j][i] = true;
                }
            }
        }

        Set<Integer> q = new HashSet<Integer>();
        dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            q.add(i);
        }
        dist[n - 1] = 1;
        
        while (q.isEmpty() == false) {
            
            int u = -1;
            int uDist = Integer.MAX_VALUE;
            for (Integer lu : q) {
                if (dist[lu] < uDist || u == -1) {
                    u = lu;
                    uDist = dist[lu];
                }
            }
            if (uDist == Integer.MAX_VALUE) {
                break;
            }
            if (u == destIndex) {
                break;
            }
            
            q.remove(u);
            
            for (int v = 0; v < n; v++) {
                if (p[u][v] == false) {
                    continue;
                }
                int alt = dist[u] + 1;
                if (alt < dist[v]) {
                    dist[v] = alt;
                }
            }
        }
        
        return dist[destIndex] == Integer.MAX_VALUE ? 0 : dist[destIndex];
    }

}