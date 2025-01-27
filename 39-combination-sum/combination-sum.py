class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def myFun(index,arr,s):
            if s == target:
                res.append(arr[:])
                return
            if s > target:
                return
            for j in range(index,len(candidates)):
                arr.append(candidates[j])
                myFun(j,arr,s+candidates[j])
                arr.pop(-1)
        myFun(0,[],0)
        return res