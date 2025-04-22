class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        fun(0,"",result,n);
        return result;
    }
    public void fun(int index, String curr, List<String> result, int n){
        if(index == n){
            result.add(curr);
            return;
        }
        fun(index + 1, curr + "1",result,n);
        if(curr.length() < 1 || curr.charAt(curr.length()-1) != '0'){
            fun(index + 1, curr + "0",result,n);
        }
    }
}