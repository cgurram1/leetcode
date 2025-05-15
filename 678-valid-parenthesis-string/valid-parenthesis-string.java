// import java.util.*;

// class Solution {
//     public boolean checkValidString(String s) {
//         Map<String, Boolean> memo = new HashMap<>();
//         return fun(0, s, 0, memo);
//     }
//     public boolean fun(int index, String s, int open, Map<String, Boolean> memo) {
//         if (open < 0) {
//             return false;
//         }
//         if (index == s.length()) {
//             return open == 0;
//         }
//         String key = index + "," + open;
//         if (memo.containsKey(key)) {
//             return memo.get(key);
//         }
//         boolean res;
//         char ch = s.charAt(index);
//         if (ch == '(') {
//             res = fun(index + 1, s, open + 1, memo);
//         } else if (ch == ')') {
//             res = fun(index + 1, s, open - 1, memo);
//         } else {
//             res = fun(index + 1, s, open + 1, memo) ||
//                   fun(index + 1, s, open - 1, memo) ||
//                   fun(index + 1, s, open, memo);
//         }
//         memo.put(key, res);
//         return res;
//     }
// }


// Stack Solution
// Store the indices of ( and * in seperate stacks. try to match the closing first with any opening if not match it with *. If none, then false;

// Now match the remaining ( if any with tphe * if the * appears after the (

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stackParan = new Stack<>();
        Stack<Integer> stackStar = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stackParan.push(i);
            }
            else if(s.charAt(i) == '*'){
                stackStar.push(i);
            }
            else{
                if(!stackParan.isEmpty()){
                    stackParan.pop();
                }
                else if(!stackStar.isEmpty()){
                    stackStar.pop();
                }
                else{
                    return false;
                }
            }
        }
        while(!stackParan.isEmpty() && !stackStar.isEmpty()){
            if(stackParan.peek() < stackStar.peek()){
                stackParan.pop();
                stackStar.pop();
            }
            else{
                return false;
            }
        }
        return stackParan.isEmpty();
    }
}