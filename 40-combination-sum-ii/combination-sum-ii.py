class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()
        def myFun(index, arr,s):
            print(arr)
            if s == target:
                res.append(arr[:])
                return
            if s > target:
                return
            for j in range(index,len(candidates)):
                if j > index and candidates[j] == candidates[j-1]:
                    continue
                if candidates[j] > target:
                    break
                arr.append(candidates[j])
                myFun(j+1,arr,s+candidates[j])
                arr.pop(-1)
        myFun(0,[],0)
        return res
            