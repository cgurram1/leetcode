class Solution {
    public String robotWithString(String s) {
        Stack<Character> stack = new Stack<>();
        int [] arr = new int[26];
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            arr[s.charAt(i) - 'a']+=1;
        }
        for(int i = 0;i<s.length();i++){
            stack.push(s.charAt(i));
            arr[s.charAt(i) - 'a']-=1;
            while(!stack.isEmpty() && canRemove(stack.peek(),arr)){
                str.append(stack.pop());
            }
        }
        return str.toString();
    }
    public boolean canRemove(char c,int [] arr){
        for(int i = 0;i<c-'a';i++){
            if(arr[i] > 0){
                return false;
            }
        }
        return true;
    }
}