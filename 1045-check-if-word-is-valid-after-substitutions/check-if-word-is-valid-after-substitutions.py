class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for ch in s:
            if ch !='c':
                stack.append(ch)
            else:
                if len(stack) >= 2 and stack[-1] + stack[-2] == "ba":
                    stack.pop(-1)
                    stack.pop(-1)
                else:
                    stack.append(ch)
        if stack:
            return False
        return True
                    

        

        