class Solution {
    public String removeKdigits(String num, int k) {
        if(k >= num.length()){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<num.length();i++){
            char n = num.charAt(i);
            while(k > 0 && stack.isEmpty() == false && stack.peek() - '0' > n - '0'){
                stack.pop();
                k-=1;
            }
            stack.push(n);
        }
        while(k > 0){
            stack.pop();
            k-=1;
        }
        StringBuilder sb = new StringBuilder(stack.size());
        while(stack.isEmpty() == false){
            sb.append(stack.pop());
        }
        sb.reverse();
        String result = sb.toString().replaceFirst("^0+(?!$)", "");
        return result;
    }
}