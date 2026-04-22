class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        s = sum(nums)
        if s % 2 != 0:
            return False
        dp = [[False] * ((s//2)+1) for _ in range(len(nums)+1)]
        dp[0][0] = True
        for i in range(1,len(nums)+1):
            for r in range(s//2+1):
                dp[i][r] = dp[i-1][r]
                if not dp[i][r] and nums[i-1] <= r:
                    dp[i][r] = dp[i][r] or dp[i-1][r - nums[i-1]]
        return dp[len(nums)][s//2]