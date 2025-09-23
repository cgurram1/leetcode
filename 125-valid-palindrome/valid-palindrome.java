class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= '0' && s.charAt(i) <= '9')
            sb.append(s.charAt(i));
        }
        return fun(sb.toString(),0);
    }
    public boolean fun(String s,int i){
        if(i >= s.length()/2){
            return true;
        }
        if(s.charAt(i) == s.charAt(s.length()-1-i) && fun(s,i+1)){
            return true;
        }
        return false;
    }
}