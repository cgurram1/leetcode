class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = [1] * len(nums)
        sufix = [1] * len(nums)
        res = []
        N = len(nums)
        for i in range(N-1):
            prefix[i+1] = prefix[i] * nums[i]
            sufix[N-i-2] = sufix[N-i-1] * nums[N-i-1]
        for i in range(N):
            res.append(prefix[i] * sufix[i])
        return res