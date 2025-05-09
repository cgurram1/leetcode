class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        Map<Character, char[]> phone = new HashMap<>();
        phone.put('2', new char[]{'a', 'b', 'c'});
        phone.put('3', new char[]{'d', 'e', 'f'});
        phone.put('4', new char[]{'g', 'h', 'i'});
        phone.put('5', new char[]{'j', 'k', 'l'});
        phone.put('6', new char[]{'m', 'n', 'o'});
        phone.put('7', new char[]{'p', 'q', 'r', 's'});
        phone.put('8', new char[]{'t', 'u', 'v'});
        phone.put('9', new char[]{'w', 'x', 'y', 'z'});
        StringBuilder curr = new StringBuilder();
        rec(0,phone,curr,result,digits);
        return result;
    }
    public void rec(int index, Map<Character, char[]> phone,StringBuilder curr, List<String> result, String digits){
        if(index == digits.length()){
            result.add(new StringBuilder(curr).toString());
            return;
        }
        for(char next : phone.get(digits.charAt(index))){
            curr.append(next);
            rec(index+1,phone,curr, result, digits);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}