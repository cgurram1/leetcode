class Solution:
    def maxWidthRamp(self, nums: List[int]) -> int:
        stack = []
        stack.append((nums[0],0))
        res = float('-inf')
        x = -1
        for i in range(1,len(nums)):
            if nums[i] < stack[-1][0]:
                stack.append((nums[i],i))
                x+=1
            else:
                k = x
                while(k >= 0 and stack[k][0] <= nums[i]):
                    k-=1
                res = max(res,(i - stack[k+1][1]))
        if res == float('-inf'):
            return 0
        return res