class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def myRec(index,currSum,currArr):
            #BAse
            if currSum == target:
                res.append(currArr[:])
                return
            if index == len(candidates) or currSum > target:
                return
            #Body
            currArr.append(candidates[index])
            myRec(index,currSum + candidates[index],currArr)
            popped = currArr.pop()
            myRec(index + 1 , currSum, currArr)
        myRec(0,0,[])
        return res