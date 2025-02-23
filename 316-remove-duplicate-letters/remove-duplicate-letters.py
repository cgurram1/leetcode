class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        stack = []
        myDict = {}
        res = ""
        for i in range(len(s)):
            if s[i] in myDict:
                myDict[s[i]]+=1
            else:
                myDict[s[i]] = 1
        for i in range(len(s)):
            myDict[s[i]]-=1
            if s[i] in stack:
                continue
            while (stack and ord(s[i]) < ord(stack[-1]) and myDict[stack[-1]] > 0):
                popped = stack.pop(-1)
            stack.append(s[i])
        return "".join(stack)