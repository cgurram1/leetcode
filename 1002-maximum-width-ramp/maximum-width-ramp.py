"""
[0,1,2,3,4,5,6,7,8,9]
[9,8,1,0,1,9,4,0,4,1]

[(9,0),(8,1),(1,2),(0,3),()]


currMax = 7
"""

class Solution:
    def maxWidthRamp(self, nums: List[int]) -> int:
        result = 0
        stack = []
        for i in range(len(nums)):
            if not stack or stack[-1][0] > nums[i]:
                stack.append((nums[i],i))
            else:
                left = 0
                right = len(stack)-1
                while left <= right:
                    mid = (left + right)//2
                    if stack[mid][0] > nums[i]:
                        left = mid + 1
                    else:
                        result = max(result, i - stack[mid][1])
                        right = mid - 1
        return result
        
        

        # return max(0,result)