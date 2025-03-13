class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int result = s.length()+1;
        String res = "";
        while(right < s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) - 1);
            if(map.get(s.charAt(right)) >= 0){
                count+=1;
            }
            while(count == t.length()){
                if(right - left + 1 < result){
                    res = s.substring(left,right+1);
                    result = right - left + 1;
                }
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                if(map.get(s.charAt(left)) > 0){
                    count-=1;
                }
                left+=1;
            }
            
            right+=1;
        }
        return res;
    }
}