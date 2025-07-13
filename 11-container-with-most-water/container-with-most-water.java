class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int res = 0;
        while(left < right){
            int currCap = Math.min(height[left],height[right]) * (right - left);
            res = Math.max(currCap,res);
            if(height[left] < height[right]){
                left+=1;
            }
            else{
                right-=1;
            }
        }
        return res;
    }
}