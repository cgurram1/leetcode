class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def myRec(arr,visited):
            if len(arr) == len(nums):
                if arr[:] not in res:
                    res.append(arr[:])
                return
            for i in range(len(nums)):
                if visited[i] == False:
                    arr.append(nums[i])
                    visited[i] = True
                    myRec(arr,visited)
                    arr.pop()
                    visited[i] = False
        res = []
        myRec([],[False] * len(nums))
        return res
                