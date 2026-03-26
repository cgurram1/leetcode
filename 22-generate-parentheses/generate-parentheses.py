class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def REC(op,cl,arr):
            if op == n and cl == n:
                result.append("".join(arr))
                return
            if op < n:
                arr.append('(')
                REC(op+1,cl,arr)
                arr.pop()
            if cl < op:
                arr.append(')')
                REC(op,cl+1,arr)
                arr.pop()
        result = []
        REC(0,0,[])
        return result