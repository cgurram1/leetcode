class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def myFun(index,arr,s):
            if s == target:
                res.append(arr[:])
                return
            if s > target or index == len(candidates):
                return
            arr.append(candidates[index])
            myFun(index, arr,s+candidates[index])
            arr.pop(-1)
            myFun(index+1,arr,s)
        myFun(0,[],0)
        return res