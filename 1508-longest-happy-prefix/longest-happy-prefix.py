class Solution:
    def longestPrefix(self, s: str) -> str:
        left = 0
        right = len(s)-1
        mod = 10**9 + 9
        base = 29
        power = 1
        result = 0
        h1 = 0
        h2 = 0
        while left < len(s)-1:
            c1 = ord(s[left]) - ord('a') + 1
            c2 = ord(s[right]) - ord('a') + 1
            h1 = (h1 * base + c1) % mod
            h2 = (h2 + c2*power) % mod
            power = (power * base) % mod
            left+=1
            right-=1
            if h1 == h2:
                result = left
        return s[:result]

