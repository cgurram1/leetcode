import java.util.*;

class Solution {
    public boolean checkValidString(String s) {
        Map<String, Boolean> memo = new HashMap<>();
        return fun(0, s, 0, memo);
    }

    public boolean fun(int index, String s, int open, Map<String, Boolean> memo) {
        if (open < 0) {
            return false;
        }
        if (index == s.length()) {
            return open == 0;
        }
        String key = index + "," + open;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        boolean res;
        char ch = s.charAt(index);
        if (ch == '(') {
            res = fun(index + 1, s, open + 1, memo);
        } else if (ch == ')') {
            res = fun(index + 1, s, open - 1, memo);
        } else {
            res = fun(index + 1, s, open + 1, memo) ||
                  fun(index + 1, s, open - 1, memo) ||
                  fun(index + 1, s, open, memo);
        }
        memo.put(key, res);
        return res;
    }
}