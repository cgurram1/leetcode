class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        prev = nums[0]
        res = max(float(-inf),prev)
        for i in range(1,len(nums)):
            curr = nums[i]
            if curr > prev + curr:
                prev = curr
            else:
                prev = prev + curr
            res = max(res,prev)
        return res