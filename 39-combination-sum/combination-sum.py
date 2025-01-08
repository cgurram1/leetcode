class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def myRec(index,currSum,arr):
            if currSum == target:
                res.append(arr[:])
                return
            if index == len(candidates) or currSum > target:
                return
            arr.append(candidates[index])
            myRec(index, currSum + candidates[index],arr)
            arr.pop()
            myRec(index + 1, currSum, arr)
            return
        res = []
        myRec(0,0,[])
        return res