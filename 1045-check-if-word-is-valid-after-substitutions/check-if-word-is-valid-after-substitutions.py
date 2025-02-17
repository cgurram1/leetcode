class Solution:
    def isValid(self, s: str) -> bool:
        while("abc" in s):
            index = s.index("abc")
            s = s[:index] + s[index + 3:]
        if len(s) > 0:
            return False
        return True
        