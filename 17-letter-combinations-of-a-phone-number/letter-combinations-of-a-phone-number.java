class Solution {
    public List<String> result;
    public String digitsG;
    public Map<Character, char []> phone;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        digitsG = digits;
        phone = new HashMap<>();
        phone.put('2', new char []{'a','b','c'});
        phone.put('3', new char []{'d','e','f'});
        phone.put('4', new char []{'g','h','i'});
        phone.put('5', new char []{'j','k','l'});
        phone.put('6', new char []{'m','n','o'});
        phone.put('7', new char []{'p','q','r','s'});
        phone.put('8', new char []{'t','u','v'});
        phone.put('9', new char []{'w','x','y','z'});
        fun(0,new StringBuilder());
        return result;
    }
    public void fun(int index, StringBuilder str){
        if(index == digitsG.length()){
            if(str.length() > 0){
                result.add(str.toString());
            }
            return;
        }
        for(int i = 0;i<phone.get(digitsG.charAt(index)).length;i++){
            str.append(phone.get(digitsG.charAt(index))[i]);
            fun(index + 1, str);
            str.setLength(str.length() - 1);
        }

    }
}