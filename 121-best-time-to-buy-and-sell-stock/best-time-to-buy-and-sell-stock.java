class Solution {
    public int maxProfit(int[] prices) {
        int currMin = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        for(int i = 0;i<prices.length;i++){
            if(prices[i] < currMin){
                currMin = prices[i];
            }
            else{
                res = Math.max(res,prices[i] - currMin);
            }
        }
        if(res == Integer.MIN_VALUE){
            return 0;
        }
        return res;
    }
}