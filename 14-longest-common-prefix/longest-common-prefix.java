class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder str = new StringBuilder(201);
        int index = 0;
        while(true){
            if(index >= strs[0].length()){
                return str.toString();
            }
            char check = strs[0].charAt(index);
            for(int i = 1;i<strs.length;i++){
                if(index >= strs[i].length() || strs[i].charAt(index) != check){
                    return str.toString();
                }
            }
            str.append(check);
            index+=1;
        }
    }
}