class Solution:
    def countSubstrings(self, s: str) -> int:
        l = 0
        r = 0
        count = 0
        for i in range(len(s)):
            l = i
            r = i
            while(l >= 0 and r<len(s)):
                if s[l] == s[r]:
                    count+=1
                else:
                    break
                l-=1
                r+=1
        for i in range(len(s)):
            l = i
            r = i+1
            while(l >= 0 and r<len(s)):
                if s[l] == s[r]:
                    count+=1
                else:
                    break
                l-=1
                r+=1
        return count

            
