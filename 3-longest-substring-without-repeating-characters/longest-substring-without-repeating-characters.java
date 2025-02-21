class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;
        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            if (map.get(s.charAt(r)) > 1) {
                while (map.get(s.charAt(r)) > 1) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                    l++;
                }
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}