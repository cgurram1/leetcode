class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder res = new StringBuilder();
        int l = 0;
        while(l < s.length()){
            res.append(s.charAt(l));
            if(res.length() >= part.length() && res.toString().substring(res.length()-part.length(),res.length()).equals(part)){
                res.delete(res.length()-part.length(),res.length());
            }
            l++;
        }
        return res.toString();
    }
}