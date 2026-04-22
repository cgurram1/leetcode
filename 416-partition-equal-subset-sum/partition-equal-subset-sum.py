class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        s = sum(nums)
        if s % 2 != 0:
            return False
        h = [[-1] * ((s//2)+1) for _ in range(len(nums)+1)]
        def fun(index, remaining):
            if remaining == 0:
                return 1
            if index == len(nums) or remaining < 0:
                return 0
            if h[index][remaining] != -1:
                return h[index][remaining]
            if fun(index + 1, remaining - nums[index]) == 1 or fun(index + 1, remaining) == 1:
                h[index][remaining] = 1
            else:
                h[index][remaining] = 0
            return h[index][remaining]
        
        if fun(0,s//2) == 1:
            return True
        return False