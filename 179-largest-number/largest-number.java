class Solution {
    public String largestNumber(int[] nums) {
        String res = "";
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j < nums.length - 1 - i;j++){
                if(Double.valueOf(nums[j] + "" + nums[j+1]) > Double.valueOf(nums[j+1] + "" + nums[j])){
                    continue;
                }
                else{
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
            res = nums[nums.length - 1 - i] + res;
        }
        int i = 0;
        while(i < res.length()-1 && res.charAt(i) == '0'){
            i++;
        }

        return res.substring(i,res.length());
    }
}