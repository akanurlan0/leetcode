class Solution {
    
    private char[] c;
    private Set<String> res;
    private int maxLength;
    
    public List<String> removeInvalidParentheses(String s) {
        
        c = s.toCharArray();
        res = new HashSet<>();
        
        maxLength = 0;
        
        correct(0, new StringBuilder());
        
        List<String> list = new ArrayList<>();
        
        for (String r : res) {
            if (r.length() == maxLength) {
                list.add(r);
            }
        }
        
        return list;
    }
    
    private void correct(int index, StringBuilder sb) {
        
        if (index == c.length) {
            
            int counter = 0;
            boolean flag = true;
            
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '(') {
                    counter++;
                } else 
                if (sb.charAt(i) == ')') {
                    if (counter > 0) {
                        counter--;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            
            if (flag && counter == 0) {
                res.add(sb.toString());
                if (maxLength < sb.length()) {
                    maxLength = sb.length();
                }
            }
            
            return;
        }
        
        if (c[index] == '(' || c[index] == ')') {
            correct(index+1, sb);

            sb.append(c[index]);
            correct(index+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(c[index]);
            correct(index+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}