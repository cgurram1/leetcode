from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        def rec(index, end):
            if index >= end:
                return 0
            if dp[index] != -1:
                return dp[index]
            
            # Choose to rob the current house
            pick = nums[index] + rec(index + 2, end)
            # Skip the current house
            notPick = rec(index + 1, end)
            
            dp[index] = max(pick, notPick)
            return dp[index]

        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums)
        if len(nums) == 3:
            return max(nums)

        # First case: Rob houses from index [0, n-2]
        dp = [-1] * len(nums)
        case1 = rec(0, len(nums) - 1)

        # Second case: Rob houses from index [1, n-1]
        dp = [-1] * len(nums)
        case2 = rec(1, len(nums))

        return max(case1, case2)
