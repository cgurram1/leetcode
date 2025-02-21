class Solution {
    public int trap(int[] height) {
        int [] leftPeak = new int[height.length];
        int [] rightPeak = new int[height.length];
        int res = 0;
        int currLeftPeak = height[0];
        int currRightPeak = height[height.length - 1];
        for(int i = 0;i<height.length;i++){
            currLeftPeak = Math.max(height[i],currLeftPeak);
            leftPeak[i] = currLeftPeak;
        }
        for(int i = height.length - 1;i>=0;i--){
            currRightPeak = Math.max(height[i],currRightPeak);
            rightPeak[i] = currRightPeak;
        }
        for(int i = 0;i<height.length;i++){
            res += Math.min(rightPeak[i],leftPeak[i]) - height[i];
        }
        return(res); 
    }
}