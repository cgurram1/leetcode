class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums = sorted(nums)
        N = len(nums)
        for i,a in enumerate(nums):
            if i > 0 and a == nums[i-1]:
                continue
            right = N - 1
            left = i + 1
            while(left < right):
                if a + nums[left] + nums[right] > 0:
                    right-=1
                elif a + nums[left] + nums[right] < 0:
                    left+=1
                else:
                    res.append([a,nums[left],nums[right]])
                    left+=1
                    while(nums[left] == nums[left - 1] and left < right):
                        left+=1
        return res
