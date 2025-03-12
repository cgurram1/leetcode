class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int res = 0;
        for(int num : set){
            if(set.contains(num-1)){
                continue;
            }
            else{
                int curr = num + 1;
                int count = 1;
                while(set.contains(curr)){
                    count+=1;
                    curr+=1;
                }
                res = Math.max(res,count);
            }
        }
        return res;
    }
}