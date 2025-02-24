class Solution:
    def reverseParentheses(self, s: str) -> str:
        stack = []
        for ch in s:
            if ch == ')':
                curr = ""
                while(stack and stack[-1] != '('):
                    curr+=(stack.pop(-1)[::-1])
                stack.pop(-1)
                stack.append(curr)
            else:
                stack.append(ch)
        return "".join(stack)