class Solution:
    def frequencySort(self, s: str) -> str:
        freqs = {}
        for c in s:
            if(c in freqs):
                freqs[c]+=1
            else:
                freqs[c] = 1
        sorted_freqs = sorted(freqs.items(), key=lambda x:x[1],reverse=True)
        # print(sorted_freqs)
        res = ""
        for item in sorted_freqs:
            for i in range(item[1]):
                res+=item[0]
        # print(sorted_freqs)
        return res