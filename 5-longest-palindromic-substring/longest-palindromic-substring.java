class Solution {
    public String longestPalindrome(String s) {
        int res = 0;
        int maxl = 0;
        int maxr = 0;
        int count = 0;
        for(int i = 0;i<s.length();i++){
            int l = i;
            int r = i;
            count = 0;
            while(l>=0 && r < s.length()){
                if(s.charAt(l) == s.charAt(r)){
                    count+=1;
                }
                else{
                    break;
                }
                if(count > res){
                    res = count;
                    maxl = l;
                    maxr = r;
                }
                l-=1;
                r+=1;
            }
            
        }
        for(int i = 0;i<s.length();i++){
            int l = i;
            int r = i+1;
            count = 1;
            while(l>=0 && r < s.length()){
                if(s.charAt(l) == s.charAt(r)){
                    count+=1;
                }
                else{
                    break;
                }
                if(count > res){
                    res = count;
                    maxl = l;
                    maxr = r;
                }
                l-=1;
                r+=1;
            }
        }
        return s.substring(maxl,maxr+1);
    }
}