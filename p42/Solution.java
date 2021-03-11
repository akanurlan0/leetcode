class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        
        int[][] history = new int[n][3];
        int hSize = 0;
        
        for (int i = 0; i < height.length; i++) {
            
            int currHeight = height[i];
            
            if (height[i] == 0) continue; 
            
            int searchIndex = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (height[j] <= height[j+1]) continue;
                
                if (searchIndex == -1) {
                    searchIndex = j;
                    if (height[j] >= height[i]) {
                        break;
                    }
                    continue;
                }
                if (height[j] > height[searchIndex]) {
                    searchIndex = j;
                    if (height[j] >= height[i]) {
                        break;
                    }
                }
            }

            if (searchIndex == -1) continue;

            if (i - searchIndex < 2) continue;
            
            // System.out.print(searchIndex + " " + i + " ");
            
            int minHeight = height[i] > height[searchIndex] ? height[searchIndex] : height[i];

            // System.out.print(minHeight + " ");
            
            int area = minHeight * (i - searchIndex - 1) - getOccupiedArea(height, searchIndex + 1, i - 1, minHeight);
            
            // System.out.print(area + " ");
            // System.out.println();
            
            boolean historyMatch = false;
            int deleteCounter = 0;
            for (int j = hSize - 1; j >= 0; j--) {
                if (searchIndex <= history[j][0] && history[j][1] <= i) {
                    history[j][0] = searchIndex;
                    history[j][1] = i;
                    history[j][2] = area > history[j][2] ? area : history[j][2];
                    historyMatch = true;
                    hSize -= deleteCounter++;
                }
            }
            
            if (historyMatch == false) {
                history[hSize][0] = searchIndex;
                history[hSize][1] = i;
                history[hSize][2] = area;
                hSize++;
            }
        }
        
        for (int i = 0; i < hSize; i++) {
            System.out.println(history[i][0] + " " + history[i][1] + " " + history[i][2]);
        }
        
        int res = 0;
        for (int i = 0; i < hSize; i++) {
            res += history[i][2];
        }
        return res;
    }
    
    private int getOccupiedArea(int[] height, int l, int r, int minHeight) {
        int res = 0;
        for (int i = l; i <= r; i++) {
            res += minHeight > height[i] ? height[i] : minHeight;
        }
        return res;
    }
}