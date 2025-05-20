class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<num.length();i++){
            while(k > 0 && !stack.isEmpty() && Integer.parseInt(stack.peek() + "") > Integer.parseInt(num.charAt(i) + "")){
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
        String res = "";
        for(int i = 0;i<stack.size();i++){
            // System.out.println(arr[i]);
            if(res == "" && (Character)arr[i] == '0'){
                continue;
            }
            res = res + arr[i];
        }
        if(res == ""){
            return "0";
        }
        return res;
    }
}