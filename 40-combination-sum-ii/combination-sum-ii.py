"""

10,1,2,7,6,1,5

1,1,2,5,6,7,10

"""
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def REC(index, total, arr):
            if total == target:
                result.append(arr.copy())
                return
            if index == len(candidates) or total > target:
                return
            #Pick
            arr.append(candidates[index])
            REC(index + 1, total + candidates[index], arr)
            arr.pop()
            #Do not Pick
            while index + 1 < len(candidates) and candidates[index + 1] == candidates[index]:
                index+=1
            REC(index + 1, total, arr)
            
        candidates.sort()  
        result = []
        REC(0,0,[])
        return result