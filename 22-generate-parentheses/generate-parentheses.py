class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        def myRec(o,c,res):
            if o == n and c == n and res not in result:
                result.append(res)
                return
            if o <= n:
                if o > c:
                    myRec(o,c+1, res+")") 
                if o < n:
                    myRec(o+1,c,res+ "(")
            
        myRec(0,0,"")
        return result
