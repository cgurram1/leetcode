import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: Store frequency of characters in `t`
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0, count = 0;
        int minStart = 0, minLength = s.length() + 1;

        while (right < s.length()) {
            char rChar = s.charAt(right);
            map.put(rChar, map.getOrDefault(rChar, 0) - 1);
            if (map.get(rChar) >= 0) {
                count++;
            }

            while (count == t.length()) {
                if (right - left + 1 < minLength) {
                    minStart = left;  // Store the start index
                    minLength = right - left + 1;  // Store the length
                }

                char lChar = s.charAt(left);
                map.put(lChar, map.get(lChar) + 1);
                if (map.get(lChar) > 0) {
                    count--;
                }
                left++;
            }

            right++;
        }

        // Extract substring only once at the end
        return (minLength == s.length() + 1) ? "" : s.substring(minStart, minStart + minLength);
    }
}
