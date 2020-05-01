/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int left = 1;
        int right = n;
        while (right > left) {
            
            int center = left + ((right - left)/2);
            
            boolean isBadVersion = isBadVersion(center);
            
            if (isBadVersion == true) {
                right = center;
            } else {
                left = center + 1;
            }
        }
        
        return right;
        
    }
}