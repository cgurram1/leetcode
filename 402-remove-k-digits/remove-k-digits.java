class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<num.length();i++){
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        Object [] arr = stack.toArray();
        StringBuilder res = new StringBuilder();
        for(int i = 0;i<stack.size();i++){
            if(res.length() == 0 && (Character)arr[i] == '0'){
                continue;
            }
            res = res.append(arr[i]);
        }
        if(res.length() == 0){
            return "0";
        }
        return res.toString();
    }
}