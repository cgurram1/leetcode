class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0;
        int right = 0;
        int [] index = new int[3];
        Arrays.fill(index,-1);
        int res = 0;
        while(left < s.length()){
            while((right < s.length()) && (index[0] == -1 || index[1] == -1 || index[2] == -1)){
                index[s.charAt(right) - 'a'] = right;
                right+=1;
            }
            if(right == s.length() && ((index[0] == -1 || index[1] == -1 || index[2] == -1))){
                break;
            }
            res += (s.length() - right + 1);
            if(index[s.charAt(left) - 'a'] == left){
                index[s.charAt(left) - 'a'] = -1;
            }
            left +=1;
        }
        return res;
    }
}