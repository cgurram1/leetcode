class Solution:
    def firstUniqChar(self, s: str) -> int:
        m = {}
        for ch in s:
            if ch in m:
                m[ch]+=1
            else:
                m[ch] = 1
        for i,ch in enumerate(s):
            if m[ch] == 1:
                return i
        return -1
