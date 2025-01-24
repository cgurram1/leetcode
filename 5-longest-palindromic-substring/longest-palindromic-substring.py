class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return s
        new_s = "#"
        for ch in s:
            new_s = new_s + ch + "#"
        curr = new_s[0]
        for i in range(len(new_s)):
            l = i - 1
            r = i + 1
            while(l >= 0 and r < len(new_s)):
                if new_s[l] == new_s[r]:
                    if (r - l + 1) > len(curr):
                        curr = new_s[l:r+1]
                    l -= 1 
                    r += 1
                else:
                    break
        res = ""
        for ch in curr:
            if ch != "#":
                res+=ch
        return res