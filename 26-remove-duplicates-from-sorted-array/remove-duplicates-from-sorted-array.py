class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        left = 0
        prev = None
        for num in nums:
            if num != prev:
                nums[left] = num
                prev = num
                left+=1
        return left