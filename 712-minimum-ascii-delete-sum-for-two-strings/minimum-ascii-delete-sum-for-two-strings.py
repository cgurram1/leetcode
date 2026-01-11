class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        @lru_cache(None)
        def rec(i1, i2):
            if(i1 == len(s1)):
                return sum((ord(c) for c in s2[i2:]))
            if(i2 == len(s2)):
                return sum((ord(c) for c in s1[i1:]))
            if(s1[i1] == s2[i2]):
                return rec(i1+1, i2 + 1)
            del1 = ord(s1[i1]) + rec(i1 + 1, i2)
            del2 = ord(s2[i2]) + rec(i1, i2 + 1)
            return min(del1, del2)
        return rec(0,0)