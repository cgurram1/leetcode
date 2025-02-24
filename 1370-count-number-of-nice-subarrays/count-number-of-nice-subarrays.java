class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return func(nums,k) - func(nums,k-1);
    }
    public static int func(int [] nums,int goal){
        int r = 0;
        int l = 0;
        int oddCount = 0;
        int res = 0;
        while(r < nums.length){
            if(nums[r] % 2 != 0){
                oddCount+=1;
            }
            while(l <= r && oddCount > goal){
                if(nums[l] % 2 != 0){
                    oddCount-=1;
                }
                l+=1;
            }
            if(oddCount <= goal){
                res = res + (r - l + 1);
            }
            r+=1;
        }
        return res;   
    }
}