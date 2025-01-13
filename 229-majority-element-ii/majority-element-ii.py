class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        nums = sorted(nums)
        target = len(nums)//3
        count = 1
        res = []
        for i in range(len(nums)-1):
            if nums[i] == nums[i+1]:
                count+=1
            else:
                if count > target:
                    res.append(nums[i])
                count = 1
        if count > target:
            res.append(nums[-1])
        return res
            