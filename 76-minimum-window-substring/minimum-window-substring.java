class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        Map<Character,Integer> map = new HashMap<>();
        int lmin = Integer.MAX_VALUE;
        int rmin = Integer.MAX_VALUE;
        int r = 0;
        int l = 0;
        int count = 0;
        int res = s.length()+1;
        for(int i = 0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))+ 1);
            }
            else{
                map.put(t.charAt(i),1);
            }
        }
        while(r < s.length()){
            if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),map.get(s.charAt(r)) - 1);
            }
            else{
                map.put(s.charAt(r),-1);
            }
            if(map.get(s.charAt(r)) >= 0){
                count+=1;
            }
            while(count == t.length()){
                if( r - l + 1 < res){
                    lmin = l;
                    rmin = r;
                    res = r - l + 1;
                }
                map.put(s.charAt(l),map.get(s.charAt(l)) + 1);
                if(map.get(s.charAt(l)) > 0){
                    count-=1;
                }
                l+=1;
            }
            r+=1;
        }
        if(lmin == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(lmin,rmin+1);
    }
}