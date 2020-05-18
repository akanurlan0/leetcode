class Solution {
    
    private char[] c;
    private Set<String> res;
    private int maxLength;
    
    public List<String> removeInvalidParentheses(String s) {
        
        c = s.toCharArray();
        res = new HashSet<>();
        
        maxLength = 0;
        
        correct(0, 0, new StringBuilder());
        
        List<String> list = new ArrayList<>();
        
        for (String r : res) {
            if (r.length() == maxLength) {
                list.add(r);
            }
        }
        
        return list;
    }
    
    private void correct(int index, int counter, StringBuilder sb) {
        
        if (index == c.length) {
            
            if (counter == 0) {
                res.add(sb.toString());
                if (maxLength < sb.length()) {
                    maxLength = sb.length();
                }
            }
            
            return;
        }

        if (c[index] == '(') {
            correct(index+1, counter, sb);
            
            sb.append(c[index]);
            correct(index+1, counter+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else 
        if (c[index] == ')') {

            correct(index+1, counter, sb);
            
            if (counter > 0) {
                sb.append(c[index]);
                correct(index+1, counter-1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            sb.append(c[index]);
            correct(index+1, counter, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}