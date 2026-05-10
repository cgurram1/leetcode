class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        target = sum(nums) - x  
        left, right = 0, 0

        if target == 0:
            return len(nums)

        currSum = 0
        currMax = -1   # changed from 0 -> -1

        while right < len(nums):
            currSum += nums[right]

            while left < right and currSum > target:   # removed left < right
                currSum -= nums[left]
                left += 1

            if currSum == target:
                currMax = max(currMax, right - left + 1)

            right += 1

        if currMax == -1:
            return -1

        return len(nums) - currMax