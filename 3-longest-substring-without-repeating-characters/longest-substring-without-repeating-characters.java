class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(r < s.length()){
            if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),map.get(s.charAt(r))+1);
            }
            else{
                map.put(s.charAt(r),1);
            }
            if(map.size() != r-l+1){
                if(map.get(s.charAt(l)) == 1){
                    map.remove(s.charAt(l));
                }
                else{
                    map.put(s.charAt(l), map.get(s.charAt(l))-1);
                }
                l++;
            }
            if(map.size() == r-l+1){
                res = Math.max(res,r-l+1);
            }
            r++;
        }
        return res;
    }
}