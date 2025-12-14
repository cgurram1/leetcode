class Solution {
    public int jump(int[] nums) {
        // [2,3,1,1,4]
        //    ...
        if(nums.length <= 1){
            return 0;
        }
        int steps = 1;
        int [] currRange = new int[]{1,nums[0]};
        while(currRange[1] < nums.length-1){
            steps+=1;
            int maxR = 0;
            for(int i = currRange[0];i <= currRange[1];i++){
                maxR = Math.max(maxR, i + nums[i]);
            }
            // if(maxR > currRange[1]){
                currRange[0] +=1;
                currRange[1] = maxR;
            // }
        }
        return steps;
    }
}