"""
[0,1,1,2]

"""
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums = list(set(nums))
        nums.sort()
        count = 1
        res = 0

        left = 0
        right = 0
        while right < len(nums):
            if left == right:
                count = 1
                right+=1
            while right < len(nums) and nums[right] == nums[right-1] + 1:
                right+=1
            res = max(res, right - left)
            left = right
        return res

            