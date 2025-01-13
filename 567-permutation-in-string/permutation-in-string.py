from collections import Counter
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1Freq = [0 for _ in range(26)]
        for ch in s1:
            s1Freq[ord(ch)-ord('a')]+=1
        l = 0
        r = len(s1)-1
        s2Freq = [0 for _ in range(26)]
        for ch in s2[l:r+1]:
            s2Freq[ord(ch)-ord('a')]+=1
        while(r < len(s2)-1):
            if s2Freq == s1Freq:
                return True
            s2Freq[ord(s2[l])-ord('a')]-=1
            l+=1
            r+=1
            s2Freq[ord(s2[r])-ord('a')]+=1
        if s2Freq == s1Freq:
            return True
        return False
