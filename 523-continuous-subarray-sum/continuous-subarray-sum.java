class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum%k) && i - map.get(sum%k) >= 2){
                return true;
            }
            map.putIfAbsent(sum%k, i);
        }
        return false;
    }
}
