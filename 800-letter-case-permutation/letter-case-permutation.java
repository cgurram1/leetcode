class Solution {
    public List<String> result;
    public String S;
    public List<String> letterCasePermutation(String s) {
        result = new ArrayList<>();
        S = s.toLowerCase();
        fun(0,new StringBuilder());
        return result;
    }
    public void fun(int index, StringBuilder str){
        if(index == S.length()){
            result.add(str.toString());
            return;
        }
        if(Character.isDigit(S.charAt(index))){
            str.append(S.charAt(index));
            fun(index+1,str);
            str.setLength(str.length()-1);
        }
        else{
            str.append(S.charAt(index));
            fun(index+1,str);
            str.setLength(str.length()-1);
            str.append((S.charAt(index)+"").toUpperCase());
            fun(index+1,str);
            str.setLength(str.length()-1);
        }
    }
}