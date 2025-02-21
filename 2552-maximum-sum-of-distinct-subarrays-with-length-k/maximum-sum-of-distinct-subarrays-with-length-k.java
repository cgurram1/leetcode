class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int l = 0;
        int r = k - 1;
        long currSum = 0;
        long res = 0;
        Map<Integer,Integer> myMap = new HashMap<>();
        for(int i = 0;i<=r;i++){
            currSum+=nums[i];
            if(myMap.containsKey(nums[i])){
                myMap.put(nums[i],myMap.get(nums[i])+1);
            }
            else{
                myMap.put(nums[i],1);
            }
        }
        if(myMap.size() == k) {
            res = currSum;
        }
        while(r < nums.length-1){
            r+=1;
            if(myMap.containsKey(nums[r])){
                myMap.put(nums[r],myMap.get(nums[r])+1);
            }
            else{
                myMap.put(nums[r],1);
            }
            currSum+=nums[r];
            currSum-=nums[l];
            if(myMap.get(nums[l]) > 1){
                myMap.put(nums[l],myMap.get(nums[l])-1);
            }
            else{
                myMap.remove(nums[l]);
            }
            l+=1;
            if(myMap.size() == k) {
                res = Math.max(res,currSum);
            }
        }
        return res;
    }
}