import java.util.Arrays;

class Solution {
    // public int[] nums;
    // public int[][] dp;

    // public int lengthOfLIS(int[] nums) {
    //     // this.nums = nums;
    //     // int n = nums.length;
    //     // dp = new int[n][n + 1];
    //     // for (int[] arr : dp) {
    //     //     Arrays.fill(arr, -1);
    //     // }
    //     // return fun(0, -1);
    // }

    // public int fun(int index, int prevIndex) {
    //     if (index == nums.length) return 0;
    //     if (dp[index][prevIndex + 1] != -1) {
    //         return dp[index][prevIndex + 1];
    //     }
    //     int pick = 0;
    //     if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
    //         pick = 1 + fun(index + 1, index);
    //     }
    //     int notPick = fun(index + 1, prevIndex);
    //     dp[index][prevIndex + 1] = Math.max(pick, notPick);
    //     return dp[index][prevIndex + 1];
    // }

    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(temp.size() == 0 || nums[i] > temp.get(temp.size()-1)){
                temp.add(nums[i]);
            }
            else{
                BinaryInsert(temp,nums[i]);
            }
        }
        return temp.size();
    }
    public void BinaryInsert(List<Integer> temp, int num){
        int left = 0;
        int right = temp.size()-1;
        while(left < right){
            int mid = (left + right)/2;
            if(num > temp.get(mid)){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        temp.set(right,num);
    }

}