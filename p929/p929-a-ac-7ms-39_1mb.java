class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> set = new HashSet<>();
        
        for (String s : emails) {
            
            StringBuilder sb = new StringBuilder();
            
            boolean localPart = true;
            boolean ignore = false;
            
            for (char c : s.toCharArray()) {
                
                if (c == '@') localPart = false;
                
                if (localPart) {
                    if (c == '.') continue;
                    if (c == '+') ignore = true;
                    
                    if (!ignore) sb.append(c);
                } else {
                    sb.append(c);
                }
            }
            
            set.add(sb.toString());
        }
        
        return set.size();
    }
}