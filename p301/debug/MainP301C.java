import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MainP301C {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeInvalidParentheses(")(");
    }

    static class Solution {

        public List<String> removeInvalidParentheses(String s) {

            List<Pair> q = new ArrayList<>();
            int l = 0;
            q.add(new Pair(s, 0));

            Set<String> visited = new HashSet<String>();

            List<String> res = new ArrayList<>();

            boolean maxLengthFound = false;

            while (l < q.size()) {

                Pair pair = q.get(l++);
                String curr = pair.s;
                int lastDeletedPos = pair.lastDeletedPos;

                if (isValid(curr)) {
                    res.add(curr);
                    maxLengthFound = true;
                }

                if (maxLengthFound) {
                    continue;
                }

                for (int i = lastDeletedPos; i < curr.length(); i++) {
                    char c = curr.charAt(i);
                    if ((c == '(' || c == ')') && (i == lastDeletedPos || c != curr.charAt(i-1))) {
                        String v = curr.substring(0, i) + curr.substring(i+1, curr.length());
                        if (visited.contains(v) == false) {
                            q.add(new Pair(v, i));
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

        class Pair {
            public final String s;
            public final int lastDeletedPos;

            public Pair(String s, int lastDeletedPos) {
                this.s = s;
                this.lastDeletedPos = lastDeletedPos;
            }
        }

    }
}

