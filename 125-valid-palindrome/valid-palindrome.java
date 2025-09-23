class Solution {
    public boolean isPalindrome(String s) {
        return fun(s.toLowerCase(),0,s.length()-1);
    }
    public boolean fun(String s,int l,int r){
        if(l >= r){
            return true;
        }
        while(l < r && (s.charAt(l) < '0' || s.charAt(l) > '9') && (s.charAt(l) < 'a' || s.charAt(l) > 'z')){
            l++;
        }
        while(l < r && (s.charAt(r) < '0' || s.charAt(r) > '9') && (s.charAt(r) < 'a' || s.charAt(r) > 'z')){
            r--;
        }
        if(s.charAt(l) == s.charAt(r) && fun(s,l+1,r-1)){
            return true;
        }
        return false;
    }
}