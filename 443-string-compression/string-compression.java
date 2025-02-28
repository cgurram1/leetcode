class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1){
            return 1;
        }
        StringBuilder s  = new StringBuilder();
        int count;
        for(int i = 0;i<chars.length;i++){
            s.append(chars[i]);
            count = 1;
            while(i+1 < chars.length && chars[i] == chars[i+1]){
                i++;
                count++;
            }
            if(count > 1){
                s.append(count);
            }
        }
        for(int i = 0;i<s.length();i++){
            chars[i] = s.charAt(i);
        }
        return s.length();
    }
}