class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        stack = []
        myDict = {char: s.count(char) for char in s}
        inStack = set()
        for char in s:
            myDict[char] -= 1 
            if char in inStack:
                continue
            while stack and char < stack[-1] and myDict[stack[-1]] > 0:
                inStack.remove(stack.pop())
            stack.append(char)
            inStack.add(char)
        return "".join(stack)