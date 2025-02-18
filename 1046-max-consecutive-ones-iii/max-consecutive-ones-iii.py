class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        l = 0
        r = 0
        count = 0
        max1 = float('-inf')
        while(r < len(nums)):
            if nums[r] == 0:
                k-=1
            if k < 0:
                if nums[l] == 0:
                    k+=1
                l+=1
            if k >= 0:
                max1 = max(max1,r-l+1)
            r+=1
        return max1
            
