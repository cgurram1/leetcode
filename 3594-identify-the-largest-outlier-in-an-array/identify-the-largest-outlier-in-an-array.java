class Solution {
    public int getLargestOutlier(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int totalSum = 0;
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            totalSum+=nums[i];
        }
        Arrays.sort(nums);
        for(int i = nums.length - 1;i>=0;i--){
            int outLier = nums[i];
            int remainingSum = totalSum - outLier;
            if(remainingSum % 2 != 0){
                continue;
            }
            map.put(outLier, map.get(outLier)-1);
            if(map.containsKey(remainingSum/2) && map.get(remainingSum/2) > 0){
                return outLier;
            }
            map.put(outLier, map.get(outLier) + 1);
        }
        return -1;
    }
}