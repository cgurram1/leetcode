class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        parCount = 0
        stack = []
        for ch in s:
            if ch == '(':
                parCount+=1
                stack.append(ch)
            elif ch == ')':
                if parCount > 0:
                    res = ")"
                    while(stack[-1] != '('):
                        res = stack[-1] + res
                        stack.pop(-1)
                    res = '(' + res
                    parCount-=1
                    stack.pop(-1)
                    stack.append(res)
            else:
                stack.append(ch)
        res = "".join(stack)
        i = len(res)-1
        while(parCount > 0):
            if res[i] == '(':
                res = res[:i] + res[i+1:]
                parCount-=1
            i-=1
        return res
                    
            