class Solution:
    def maxWidthRamp(self, nums: List[int]) -> int:
        stack = []
        res = float('-inf')
        for i in range(len(nums)):
            if not stack or nums[i] < nums[stack[-1]]:
                stack.append(i)
        for i in range(len(nums)-1,-1,-1):
            while(stack and nums[stack[-1]] <= nums[i]):
                popped = stack.pop(-1)
            res = max(res,(i - popped))
        if res == float('-inf'):
            return 0
        return res