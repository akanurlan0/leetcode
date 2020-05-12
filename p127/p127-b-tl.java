class Solution {
    
    private String beginWord, endWord;
    private String[] l;
    private int n;
    private boolean[][] p;
    private boolean[] visited;
    private int pathMin;
    private int destIndex;
    
    // private int[] dist;
    
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

        pathMin = Integer.MAX_VALUE;
        
        visited = new boolean[n];
        
        // dfs(n - 1, 1);
        
        return pathMin == Integer.MAX_VALUE ? 0 : pathMin;
    }
    
    private void dfs(int curr, int pathLen) {
        
        if (curr == destIndex) {
            if (pathLen < pathMin) {
                pathMin = pathLen;
            }
            return;
        }
        
        visited[curr] = true;
        
        for (int i = 0; i < n; i++) {
            if (p[curr][i] && visited[i] == false) {
                
                dfs(i, pathLen+1);
            }
        }
        
        visited[curr] = false;
    }
}