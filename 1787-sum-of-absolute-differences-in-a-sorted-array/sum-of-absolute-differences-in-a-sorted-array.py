class Solution:
    def getSumAbsoluteDifferences(self, nums: List[int]) -> List[int]:
        prefixSum = [nums[0]]
        for num in nums[1:]:
            prefixSum.append(prefixSum[-1] + num)

        n = len(nums)
        result = [0 for _ in range(n)]

        for i in range(n):
            left = nums[i] * i - (prefixSum[i-1] if i > 0 else 0)
            right = (prefixSum[n-1] - prefixSum[i]) - nums[i] * (n - i - 1)
            result[i] = left + right

        return result