"""

"""

class Solution:
    def minSwaps(self, s: str) -> int:
        left = 0
        right = len(s)-1
        op = 0
        cl = 0
        result = 0
        while left < right:
            if s[left] == '[':
                op+=1
            else:
                cl+=1
            if cl > op:
                while s[right] != '[':
                    right-=1
                right-=1
                result+=1
                cl-=1
                op+=1
            left+=1
        return result
            