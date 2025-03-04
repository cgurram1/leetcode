class Solution {
    public int jump(int[] nums) {
        int [] mins = new int[nums.length];
        if(nums.length == 1){
            return 0;
        }
        if(nums.length == 2){
            return 1;
        }
        Arrays.fill(mins,0);
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]== 0){
                mins[i] = Integer.MAX_VALUE;
            }
            else{
                int currMin = Integer.MAX_VALUE;
                for(int j = i+1;j<=i+nums[i];j++){
                    if(j < nums.length){
                        currMin = Math.min(currMin, mins[j]);
                    }
                }
                if(currMin == Integer.MAX_VALUE){
                    mins[i] = currMin;
                }
                else{
                    mins[i] = currMin + 1;
                }
                
            }
        }
        return mins[0];
    }
}