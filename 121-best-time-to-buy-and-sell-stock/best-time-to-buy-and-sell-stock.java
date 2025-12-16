
// [7,1,5,3,6,4]

// min : 1
// diff: 5
class Solution {
    public int maxProfit(int[] prices) {
        int minV = Integer.MAX_VALUE;
        int diff = 0;
        for(int i = 0;i<prices.length;i++){
            minV = Math.min(minV, prices[i]);
            diff = Math.max(diff, prices[i] - minV);
        }
        return diff;
        
    }
}