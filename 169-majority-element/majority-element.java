class Solution {
    public int majorityElement(int[] nums) {
        int elem = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(count == 0){
                elem = nums[i];
            }
            if(nums[i] == elem){
                count+=1;
            }
            else{
                count-=1;
            }
        }
        return elem;
    }
}