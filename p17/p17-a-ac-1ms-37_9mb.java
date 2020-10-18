class Solution {
    
    private List<List<Character>> map = Arrays.asList(
        new ArrayList<>(),
        Arrays.asList('a', 'b', 'c'),
        Arrays.asList('d', 'e', 'f'),
        Arrays.asList('g', 'h', 'i'),
        Arrays.asList('j', 'k', 'l'),
        Arrays.asList('m', 'n', 'o'),
        Arrays.asList('p', 'q', 'r', 's'),
        Arrays.asList('t', 'u', 'v'),
        Arrays.asList('w', 'x', 'y', 'z')
    );
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        backtracking(result, new StringBuilder(), digits, 0);
        
        return result;
    }
    
    private void backtracking(List<String> result, StringBuilder sb, String digits, int index) {
        
        if (index == digits.length()) {
            if (sb.length() > 0) {
                result.add(sb.toString());
            }
            return;
        }
        
        int digit = digits.charAt(index) - '0';
        List<Character> chars = map.get(digit - 1);
        
        for (Character c : chars) {
            sb.append(c);
            backtracking(result, sb, digits, index + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}