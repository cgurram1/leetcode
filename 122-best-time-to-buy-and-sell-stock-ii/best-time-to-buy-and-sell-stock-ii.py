class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        inHand = 0
        res = 0
        curr = 0
        i = 0
        while(i<len(prices)-1):
            if inHand == 0:
                while(i<len(prices)-1 and prices[i] >= prices[i+1]):
                    i+=1
                curr = prices[i]
                inHand = 1
            else:
                while(i<len(prices)-1 and prices[i] < prices[i+1]):
                    i+=1
                res = res + prices[i] - curr
                inHand = 0
        return res 

