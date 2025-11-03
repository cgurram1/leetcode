class Solution {
    public int minCost(String colors, int[] neededTime) {
        int index = 1;
        int runningTotal = neededTime[0];
        int currMax = neededTime[0];
        int result = 0;
        while(index < colors.length()){
            if(colors.charAt(index) != colors.charAt(index-1)){
                result = result + (runningTotal - currMax);
                runningTotal = neededTime[index];
                currMax = runningTotal;
            }
            else{
                currMax = Math.max(currMax, neededTime[index]);
                runningTotal+=neededTime[index];
            }
            index+=1;
        }

        return result + (runningTotal - currMax);
    }
}