class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        res = []
        for i in range(2 * len(nums) - 1,-1,-1):
            while(stack and stack[-1] <= nums[i % len(nums)]):
                stack.pop(-1)
            if i < len(nums):
                if not stack:
                    res.append(-1)
                else:
                    res.append(stack[-1])
            stack.append(nums[i % len(nums)])
        return res[::-1]

