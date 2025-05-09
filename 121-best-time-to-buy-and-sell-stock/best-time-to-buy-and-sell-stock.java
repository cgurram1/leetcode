class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;;
        int res = 0;
        for(int i = 0;i<prices.length;i++)
        {
            if(min > prices[i])
            {
                min = prices[i];
            }
            else
            {
                res = Math.max(res,prices[i]-min);
            }
        }
        return res;
    }
}