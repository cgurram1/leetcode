class Solution {
    public String clearStars(String s) {
        Stack<Integer> [] arr = new Stack[26];
        Set<Integer> toRemove = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            arr[i] = new Stack<>();
        }
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) != '*'){
                arr[s.charAt(i)-'a'].push(i);
            }
            else{
                for(int j = 0;j<26;j++){
                    if(arr[j].size() > 0){
                        toRemove.add(arr[j].pop());
                        break;
                    }
                }
            }
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(!toRemove.contains(i) && s.charAt(i) != '*'){
                str.append(s.charAt(i));
            }
        }
        System.out.println(toRemove);
        return str.toString();
    }
}