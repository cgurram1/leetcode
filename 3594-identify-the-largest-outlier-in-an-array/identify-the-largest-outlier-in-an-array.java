class Solution {
    public int getLargestOutlier(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int totalSum = 0;
        int res = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            totalSum+=nums[i];
        }
        for(int i = nums.length - 1;i>=0;i--){
            int outLier = nums[i];
            int remainingSum = totalSum - outLier;
            if(remainingSum % 2 == 0){
                if(remainingSum/2 == outLier){
                    if(map.get(outLier) > 1){
                        res = Math.max(res,outLier);
                    }
                }
                else{
                    if(map.containsKey(remainingSum/2)){
                        res = Math.max(res,outLier);
                    }
                }
            }
        }
        return res;
    }
}