class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for(String str : nums){
            set.add(str);
        }
        StringBuilder str = new StringBuilder();
        return fun(0, nums[0].length(), str,nums,set);
    }
    public String fun(int index, int n, StringBuilder str,String [] nums, Set<String> set){
        if(index == n){
            if(!set.contains(str.toString())){
                return str.toString();
            }
            else{
                return "";
            }
        }
        str.append('0');
        String zero = fun(index + 1, n, str,nums,set);
        if(zero != ""){
            return zero;
        }
        str.deleteCharAt(str.length()-1);
        str.append('1');
        String one = fun(index + 1, n, str,nums,set);
        if(one != ""){
            return one;
        }
        str.deleteCharAt(str.length()-1);
        return "";
    }
}