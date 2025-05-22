class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int [] diff = new int[nums.length + 1];
        diff[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            diff[i] = nums[i] - nums[i-1];
        }
        for(int i = 0;i<diff.length;i++){
            System.out.println(diff[i]);
        }
        System.out.println("--------");
        for(int i = 0;i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            diff[left]-=1;
            diff[right+1]+=1;
        }
        if(diff[0] > 0){
            return false;
        }
        for(int i = 1;i<diff.length-1;i++){
            diff[i] = diff[i] + diff[i-1];
            if(diff[i] > 0){
                return false;
            }
        }
        for(int i = 0;i<diff.length;i++){
            System.out.println(diff[i]);
        }
        return true;
    }
}