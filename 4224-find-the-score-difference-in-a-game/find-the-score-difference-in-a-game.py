class Solution:
    def scoreDifference(self, nums: List[int]) -> int:
        a = True
        count = 0
        diff = 0
        for i in range(len(nums)):
            count+=1
            if count == 6:
                count = 0
                a = not a
            if nums[i] % 2 != 0:
                a = not a
            if a:
                diff+=nums[i]
            else:
                diff-=nums[i]
        return diff


            
