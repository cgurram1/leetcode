class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp = {}
        def fun(left):
            if left == len(arr):
                return 0
            if left in dp:
                return dp[left]
            overAllMax = float('-inf')
            currMax = float('-inf')
            for i in range(left,min(len(arr),left+k)):
                currMax = max(currMax,arr[i])
                overAllMax = max(overAllMax, currMax * (i-left+1) + fun(i + 1))
            dp[left] = overAllMax
            return overAllMax
        return fun(0)
            
        
