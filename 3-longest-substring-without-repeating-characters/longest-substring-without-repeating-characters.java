class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxR = 0;
        while(right < s.length()){
            if(map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) >= left){
                left = map.get(s.charAt(right)) + 1;
            }
            map.put(s.charAt(right),right);
            maxR = Math.max(maxR, right - left + 1);
            right+=1;
        }
        
        return maxR;
    }
}