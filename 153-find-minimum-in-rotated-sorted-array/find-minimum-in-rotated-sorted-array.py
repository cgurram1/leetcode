class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums[0] > nums[-1]:
            i = len(nums) - 1
            while(nums[i] > nums[i-1]):
                i = i - 1
            return nums[i]
        else:
            return nums[0]