class Solution {
    public int compress(char[] chars) {
        int left = 0;
        int right = 0;
        int count = 0;
        int write = 0;
        while(right < chars.length){
            if(chars[right] == chars[left]){
                count+=1;
            }
            else{
                chars[write] = chars[left];
                write+=1;
                if(count > 1){
                    String countString = count + "";
                    for(int i = 0;i<countString.length();i++){
                        chars[write] = countString.charAt(i);
                        write+=1;
                    }
                }
                left = right;
                count = 1;
            }
            right+=1;
        }
        chars[write] = chars[left];
        write+=1;
        if(count > 1){
            String countString = count + "";
            for(int i = 0;i<countString.length();i++){
                chars[write] = countString.charAt(i);
                write+=1;
            }
        }
        return write;
    }
}