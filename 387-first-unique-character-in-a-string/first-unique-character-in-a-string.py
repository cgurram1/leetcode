class Solution:
    def firstUniqChar(self, s: str) -> int:
        arr = [0 for _ in range(26)]
        for ch in s:
            arr[ord(ch) - ord('a')]+=1
        for i,ch in enumerate(s):
            if arr[ord(ch) - ord('a')] == 1:
                return i
        return -1
