class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if 0 not in nums:
            return True
        else:
            res = True
            lastPossible = len(nums) - 1
            arr = [False for _ in range(len(nums))]
            for i in range(len(nums)-2, -1, -1):
                if nums[i] + i >= lastPossible:
                    lastPossible = i
                    res = True
                else:
                    res = False
            return res
