"""
aacecaaa

aaacecaa

"""
class Solution:
    def shortestPalindrome(self, s: str) -> str:
        hashKey = 0
        reversedHashKey = 0
        base = 29
        mod = 10**9 + 9
        power = 1
        matching = -1
        for i in range(len(s)):
            charEncode = ord(s[i]) - ord('a') + 1

            hashKey = (hashKey * base + charEncode) % mod
            reversedHashKey = (reversedHashKey + charEncode * power) % mod

            if hashKey == reversedHashKey:
                matching = i
            power = (power * base) % mod

        return s[matching+1:][::-1] + s