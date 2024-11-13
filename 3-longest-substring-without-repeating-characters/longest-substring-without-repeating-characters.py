class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        visited = ""
        for i in range(len(s)):
            if s[i] in visited:
                res = max(res,len(visited))
                visited=visited[visited.index(s[i])+1:]
            visited+=s[i]
        return max(res,len(visited))
