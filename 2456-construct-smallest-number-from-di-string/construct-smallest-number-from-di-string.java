class Solution {
    public String smallestNumber(String pattern) {
        int curr = 0;
        String s = "";
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<=pattern.length();i++){
            st.push(i+1);
            if(i == pattern.length() || pattern.charAt(i) == 'I'){
                while(st.isEmpty() == false){
                    s+=st.pop();
                }
            }
        }
        return s;
    }
}