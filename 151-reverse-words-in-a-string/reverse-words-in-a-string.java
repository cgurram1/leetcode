class Solution {
    public String reverseWords(String s) {
        ArrayList<StringBuilder> list = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            while(i < s.length() && s.charAt(i) != ' '){
                curr.append(s.charAt(i));
                i++;
            }
            if(curr.length() > 0){
                list.add(curr);
            }
            curr = new StringBuilder();
            while(i < s.length() && s.charAt(i) == ' '){
                i++;
            }
        }
        StringBuilder str = new StringBuilder();
        for(i = list.size()-1;i>0;i--){
            str.append(list.get(i) + " ");
        }
        str.append(list.get(0));
        return str.toString();
    }
}