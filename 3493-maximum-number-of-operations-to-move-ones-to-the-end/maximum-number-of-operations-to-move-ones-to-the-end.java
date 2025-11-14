class Solution {
    public int maxOperations(String s) {
        int count = 0;
        int curr = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                curr+=1;
            }
            else if(s.charAt(i) == '0'){
                count+=curr;
                while(i < s.length() && s.charAt(i) == '0'){
                    i+=1;
                }
                i-=1;
            }
        }
        return count;
    }
}