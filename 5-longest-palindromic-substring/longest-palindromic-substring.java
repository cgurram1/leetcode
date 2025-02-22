class Solution {
    public String longestPalindrome(String s) {
        int res = 0;
        int lmax = 0;
        int rmax = 0;
        for(int i = 0;i<s.length();i++){
            int l = i;
            int r = i;
            while((l>= 0 && r < s.length()) && s.charAt(l) == s.charAt(r)){
                l-=1;
                r+=1;
            }
            l++;
            r--;
            if(r - l + 1 > res){
                lmax = l;
                rmax = r;
                res = r - l + 1;
            }
            l = i;
            r = i+1;
            while((l>= 0 && r < s.length()) && s.charAt(l) == s.charAt(r)){
                l-=1;
                r+=1;
            }
            l++;
            r--;
            if(r - l + 1 > res){
                lmax = l;
                rmax = r;
                res = r - l + 1;
            }
        }
        return s.substring(lmax,rmax+1);
    }
}