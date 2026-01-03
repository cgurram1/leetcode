/**

aab

a      aa


 */

class Solution {
    List<List<String>> result;
    String S;
    public List<List<String>> partition(String s) {
        List<String> curr = new ArrayList<>();
        S = s;
        result = new ArrayList<>();
        recFun(0,0,new ArrayList<>());
        return result;
    }
    public void recFun(int start, int end, List<String> curr){
        if(start == S.length() && end == S.length()){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(end == S.length()){
            return;
        }
        // if start to end (inclusive) is a palindrome we recursively call from end + 1 to last
        if(isPalindrome(start,end)){
            curr.add(S.substring(start,end+1));
            recFun(end + 1,end+1,curr);
            curr.remove(curr.size()-1);
        }
        recFun(start,end+1,curr);

    }
    public boolean isPalindrome(int start, int end){
        while(start <= end){
            if(S.charAt(start) != S.charAt(end)){
                return false;
            }
            start+=1;
            end-=1;
        }
        return true;
    }
}