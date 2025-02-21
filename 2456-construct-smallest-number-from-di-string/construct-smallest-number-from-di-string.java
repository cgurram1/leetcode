class Solution {
    public String smallestNumber(String pattern) {
        int curr = 1;
        int dcount = 0;
        int [] darr = new int[pattern.length()];
        String s = "";
        for(int i = pattern.length()-1;i>=0;i--){
            if(pattern.charAt(i) == 'D'){
                dcount+=1;
            }
            else{
                dcount = 0;
            }
            darr[i] = dcount;
        }
        for(int i = 0;i<darr.length;i++){
            if(darr[i] == 0){
                s+=curr;
                curr = curr + dcount + 1;
                dcount = 0;
            }
            else{
                dcount = Math.max(dcount,darr[i]);
                s+=(darr[i] + curr);
            }
        }
        return s + curr;
    }
}