class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0;
        int r = 0;
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(r < s.length()){
            if(map.size() < 3){
                if(map.containsKey(s.charAt(r))){
                    map.put(s.charAt(r),map.get(s.charAt(r))+1);
                }
                else{
                    map.put(s.charAt(r),1);
                }
                r+=1;
            }
            else if(map.size() == 3){
                res += (s.length() - r + 1);
                if(map.get(s.charAt(l)) == 1){
                    map.remove(s.charAt(l));
                }
                else{
                    map.put(s.charAt(l),map.get(s.charAt(l))-1);
                }
                l+=1;
            }
        }
        while(l < s.length() && map.size() == 3){
            res += (s.length() - r + 1);
            if(map.get(s.charAt(l)) == 1){
                map.remove(s.charAt(l));
            }
            else{
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
            }
            l+=1;
        }
        return res;
    }
}