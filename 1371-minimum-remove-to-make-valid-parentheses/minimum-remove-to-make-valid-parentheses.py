class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        openCount = 0
        toRemove = []
        for i in range(len(s)):
            if s[i] == ')':
                if openCount == 0:
                    toRemove.append(i)
                else:
                    openCount-=1
            elif s[i] == '(':
                openCount+=1
        openCount = 0
        for i in range(len(s)-1,-1,-1):
            if s[i] == '(':
                if openCount == 0:
                    toRemove.append(i)
                else:
                    openCount-=1
            elif s[i] == ')':
                openCount+=1
        return ''.join([s[i] for i in range(len(s)) if i not in toRemove])



