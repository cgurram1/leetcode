class Solution:
    def minimumSubstringsInPartition(self, s: str) -> int:
        @lru_cache(None)
        def rec(start):
            if(start == len(s)):
                return 0
            curr = start
            freqs = defaultdict(int)
            max_freq = 0
            res = float('inf')
            while(curr < len(s)):
                freqs[s[curr]]+=1
                max_freq = max(max_freq, freqs[s[curr]])
                if max_freq * len(freqs) == curr - start + 1:
                    res = min(res, 1 + rec(curr+1))
                curr+=1
            return res
        res = rec(0)
        if(res == float('inf')):
            return -1
        return res
            