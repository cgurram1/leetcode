class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        res = 1
        freq = [0] * 26
        left = 0
        right = 0
        freq[ord(s[right]) - 65]+=1
        while(right < len(s)):
            window_len = right - left + 1
            if window_len - max(freq) <= k:
                right+=1
                if right < len(s):
                    freq[ord(s[right]) - 65]+=1
            else:
                res = max(res,window_len-1)
                freq[ord(s[left]) - 65]-=1
                left+=1
        return max(res,window_len)
                
