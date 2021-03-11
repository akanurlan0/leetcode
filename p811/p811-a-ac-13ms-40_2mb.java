class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String s : cpdomains) {
            
            int spacePos = s.indexOf(" ");
            
            int count = Integer.valueOf(s.substring(0, spacePos));
            String domain = s.substring(spacePos + 1, s.length());
            
            do {
                map.compute(domain, (k, v) -> v == null ? count : v + count);
                
                int pp = domain.indexOf(".");
                if (pp == -1) break;
                domain = domain.substring(pp + 1, domain.length());
            } while (domain.length() > 0);
        }
        
        List<String> result = new ArrayList<>();
        
        for (String k : map.keySet()) {
            String s = map.get(k) + " " + k;
            result.add(s);
        }
        
        return result;
    }
}