class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        res = [-1 for _ in range(len(nums))]
        for i in range(2*len(nums)-1,-1,-1):
            if i > (len(nums) - 1):
                while(stack and nums[i%len(nums)] >= stack[-1]):
                    stack.pop(-1)
                stack.append(nums[i%len(nums)])
            else:
                # we check the stack and update the res
                while(stack and nums[i] >= stack[-1]):
                    stack.pop(-1)
                if stack:
                    res[i] = stack[-1]
                else:
                    res[i] = -1
                stack.append(nums[i])
        return res
