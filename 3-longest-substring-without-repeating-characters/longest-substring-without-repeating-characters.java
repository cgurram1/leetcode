class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        while(right < s.length()){
            if(map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) >= left){
                left = map.get(s.charAt(right)) + 1;
            }
            map.put(s.charAt(right),right);
            res = Math.max(res, right - left + 1);
            right+=1;
        }
        return res;
    }
}