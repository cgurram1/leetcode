"""

lee(t(c)o( d  e  ) 
0123456789 10 11 12


3: (1,0)



"""
class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        toRemove = set()
        stack = []
        for i,ch in enumerate(s):
            if ch == '(':
                stack.append(i)
            elif ch == ')':
                if not stack:
                    toRemove.add(i)
                else:
                    stack.pop()
        result = []
        st = set(stack)
        for i,ch in enumerate(s):
            if i not in st and i not in toRemove:
                result.append(ch)
        return "".join(result)


