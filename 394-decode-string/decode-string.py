class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        i = 0
        while i in range(len(s)):
            if s[i] == '[':
                if not isinstance(stack[-1],int):
                    stack.append(1)
                stack.append(s[i])
            elif 'a' <= s[i] <= 'z':
                    stack.append(s[i])
            elif s[i] == ']':
                l = []
                while stack[-1] != '[':
                    l.append(stack.pop())
                stack.pop()
                poppedNum = stack.pop()
                stack.append(poppedNum * ''.join(l[::-1]))
            else:
                if stack and isinstance(stack[-1],int):
                    stack.append(stack.pop() * 10 + int(s[i]))
                else:
                    stack.append(int(s[i]))
            i+=1
                
        return ''.join(stack)


