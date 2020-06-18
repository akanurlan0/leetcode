class Solution {
    public String validIPAddress(String IP) {
        
        int dots = 0;
        int colons = 0;
        
        for (char c : IP.toCharArray()) {
            if      (c == '.') dots++;
            else if (c == ':') colons++;
        }
        
        if (dots == 3 && colons == 0) return validIPv4(IP) ? "IPv4" : "Neither";
        if (dots == 0 && colons == 7) return validIPv6(IP) ? "IPv6" : "Neither";
        return "Neither";
    }
    
    private boolean validIPv4(String ip) {
        
        String[] g = ip.split("\\.");
        
        if (g.length != 4) return false;
        
        for (String s : g) {
            if (s.length() == 0 || ( s.length() > 1 && (s.charAt(0) == '0' || Character.isDigit(s.charAt(0)) == false )) ) return false;
            
            int v;
            try {
                v = Integer.parseInt(s);
            }
            catch (Exception ex) {
                return false;
            }
            
            if (v < 0 || v > 255) return false;
        }
        
        return true; 
    }
    
    private boolean validIPv6(String ip) {
        
        String[] g = ip.split(":");
        
        if (g.length != 8) return false;
        
        for (String s : g) {
            if (s.length() == 0 || s.length() > 4 || (s.length() > 1 && Character.isLetterOrDigit(s.charAt(0)) == false )) return false;
            
            int v;
            try {
                v = Integer.parseInt(s, 16);
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
         
            if (v < 0 || v > 65535) return false;
        }
        
        return true;
    }
}