class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int result = 0;
        while(end < s.length()){
            if(map.containsKey(s.charAt(end)) == false || map.get(s.charAt(end)) < start){
                map.put(s.charAt(end),end);
                end+=1;
            }
            else{
                start = map.get(s.charAt(end)) + 1;
                map.put(s.charAt(end),end);
                end+=1;
            }
            result = Math.max(result,end-start);
        }
        return result;
    }
}