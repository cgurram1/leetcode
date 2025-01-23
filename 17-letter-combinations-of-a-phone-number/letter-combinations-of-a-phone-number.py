class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        D = ["","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"]
        res = []
        def myFun(s,index):
            if index == len(digits):
                if s:
                    res.append(s)
                return
            ind = int(digits[index])
            for i in range(len(D[ind])):
                myFun(s + D[ind][i], index + 1)
        myFun("",0)
        return res

