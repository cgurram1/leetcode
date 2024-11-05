class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        openCount = []
        closedCount = 0
        toRemove = []
        for i in range(len(s)):
            if s[i] == ')':
                if len(openCount) == 0:
                    toRemove.append(i)
                else:
                    openCount.pop()
            elif s[i] == '(':
                openCount.append(i)
        toRemove.extend(list(openCount))
        res = ""
        for i in range(len(s)):
            if i not in toRemove:
                res+=s[i]
        return res



