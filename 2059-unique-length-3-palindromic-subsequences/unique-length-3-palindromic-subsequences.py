class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        first = {}
        last = {}

        for i, ch in enumerate(s):
            if ch not in first:
                first[ch] = i
            last[ch] = i

        result = 0
        for ch in first:
            if first[ch] < last[ch]:
                result += len(set(s[first[ch]+1:last[ch]]))

        return result
