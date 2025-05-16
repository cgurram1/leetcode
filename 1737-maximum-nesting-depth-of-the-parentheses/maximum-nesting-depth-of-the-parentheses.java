class Solution {
    public int maxDepth(String s) {
        int open = 0;
        int max = 0;
        char c;
        for(int i = 0;i<s.length();i++){
            c = s.charAt(i);
            if(c == '('){
                open+=1;
            }
            else if(c == ')'){
                open-=1;
            }
            max = Math.max(max,open);
        }
        return max;
    }
}