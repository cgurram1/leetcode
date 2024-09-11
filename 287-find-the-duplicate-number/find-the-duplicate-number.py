class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        N = len(nums)
        tempArr = [-1] * N
        for i in nums:
            if tempArr[i-1] != -1:
                return i
            else:
                tempArr[i-1] = 1