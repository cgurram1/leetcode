class Solution {
    public long continuousSubarrays(int[] nums) {
        int left = 0;
        long result = 0;
        TreeMap<Integer,Integer> freq = new TreeMap<>();
        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            while (freq.lastKey() - freq.firstKey() > 2) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }
            result += right - left + 1;
        }
        return result;
    }
}