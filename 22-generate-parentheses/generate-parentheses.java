class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        rec(sb,0,0,n,arr);
        return arr;
    }
    public static void rec(StringBuilder res,int open,int close,int n,List<String> result){
        if(res.length() == 2*n){
            result.add(res.toString());
            return;
        }
        if(open < n){
            res.append("(");
            rec(res,open+1,close,n,result);
            res.deleteCharAt(res.length()-1);
        }
        if(close < open){
            res.append(")");
            rec(res,open,close+1,n,result);
            res.deleteCharAt(res.length()-1);
        }
    }
}