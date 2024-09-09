class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        left = [0] * len(nums)
        right = [0] * len(nums)
        left[0] = nums[0]
        right[-1] = nums[-1]
        N = len(nums)
        for i in range(1,N):
            left[i] = left[i-1] + nums[i]
            right[N - i - 1] = right[N-i] + nums[N - i - 1]
        for i in range(N):
            if left[i] == right[i]:
                return i
        return -1
        