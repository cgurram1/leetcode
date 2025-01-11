class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def myRec(arr,indexes):
            if len(indexes) == len(nums):
                if arr[:] not in res:
                    res.append(arr[:])
                return
            for i in range(len(nums)):
                if i not in indexes:
                    arr.append(nums[i])
                    indexes.append(i)
                    myRec(arr,indexes)
                    arr.pop()
                    indexes.pop()
        res = []
        myRec([],[])
        return res
                