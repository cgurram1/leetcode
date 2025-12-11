class Solution {
    public int characterReplacement(String s, int k) {
        int [] freqs = new int[26];
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int res = 0;
        while(right < s.length()){
            freqs[s.charAt(right) - 'A']+=1;
            maxFreq = Math.max(maxFreq, freqs[s.charAt(right) - 'A']);
            // if not valid window
            if(right - left + 1 - maxFreq > k){
                freqs[s.charAt(left) - 'A']-=1;
                left+=1;
            }
            // if valid window
            else{
                res = right - left + 1;
            }
            
            right+=1;
        }
        return res;
    }
}