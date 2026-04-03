"""

[1,2,2,3]



"""
class Solution:
    def countMajoritySubarrays(self, nums: List[int], target: int) -> int:
        result = 0
        n = len(nums)
        for i in range(n):
            count = 0
            for j in range(i,n):
                if nums[j] == target:
                    count+=1
                if count * 2 > (j-i+1):
                    result+=1
        return result
                
                