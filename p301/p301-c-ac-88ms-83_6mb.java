class Solution {
    
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> q = new ArrayList<>();
        int l = 0;
        q.add(s);
        
        Set<String> visited = new HashSet<String>();
        
        List<String> res = new ArrayList<>();
        
        boolean maxLengthFound = false;
        
        while (l < q.size()) {
            
            String curr = q.get(l++);
            
            if (isValid(curr)) {
                res.add(curr);
                maxLengthFound = true;
            }
            
            if (maxLengthFound) {
                continue;
            }
            
            for (int i = 0; i < curr.length(); i++) {
                char c = curr.charAt(i);
                if (c == '(' || c == ')') {
                    String v = curr.substring(0, i) + curr.substring(i+1, curr.length());
                    if (visited.contains(v) == false) {
                        q.add(v);
                        visited.add(v);
                    }
                }
            }
        }
        
        return res;
        
    }
    
    private boolean isValid(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                counter++;
            } else 
            if (c == ')') {
                counter--;
                if (counter < 0) return false;
            }
        }
        
        return counter == 0;
    }
    
}