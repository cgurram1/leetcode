class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        l,r = 0,0
        s = 0
        res = float('inf')
        flag = 0
        while(True):
            while(r < len(nums) and s < target):
                s+=nums[r]
                r+=1
            if s < target and r >= len(nums):
                break
            if r - l < res:
                flag = 1
                res = r - l
            while(s >= target):
                if r - l < res:
                    flag = 1
                    res = r - l
                s-=nums[l]
                l+=1
            if r == len(nums):
                break
        if flag == 1:
            return res
        return 0
