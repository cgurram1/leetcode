class Solution {
    public String[] divideString(String s, int k, char fill) {
        String [] res = new String[(int)Math.ceil((double)s.length()/k)];
        int pos = 0; 
        int i = 0;
        while(i < s.length()){
            if(i + k <= s.length()){
                res[pos] = s.substring(i,i+k);
                pos+=1;
            }
            i+=k;
        }
        i = s.length() - s.length() % k;
        if(i == s.length()){
            return res;
        }
        StringBuilder str = new StringBuilder(k);
        str.append(s.substring(i,s.length()));
        for(i = str.length();i<k;i++){
            str.append(fill);
        }
        res[pos] = str.toString();
        return res;
    }
}