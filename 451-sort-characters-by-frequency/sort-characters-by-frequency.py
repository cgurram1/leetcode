class Solution:
    def frequencySort(self, s: str) -> str:
        freqs = {}
        for c in s:
            if(c in freqs):
                freqs[c]+=1
            else:
                freqs[c] = 1
        sorted_freqs = dict(sorted(freqs.items(), key=lambda x:x[1],reverse=True))
        res = ""
        for key,value in sorted_freqs.items():
            for i in range(value):
                res+=key
        # print(sorted_freqs)
        return res