class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        maxFreqs = {}
        for word in words2:
            currFreqs = {}
            for ch in word:
                if ch in currFreqs:
                    currFreqs[ch]+=1
                else:
                    currFreqs[ch] = 1 
            for k,v in currFreqs.items():
                if k in maxFreqs:
                    maxFreqs[k] = max(maxFreqs[k], v)
                else:
                    maxFreqs[k] = v
        res = []
        for word in words1:
            currFreqs = {}
            flag = 0
            for ch in word:
                if ch in currFreqs:
                    currFreqs[ch]+=1
                else:
                    currFreqs[ch] = 1
            for k,v in maxFreqs.items():
                if k not in currFreqs or currFreqs[k] < v:
                    flag = 1
                    break
            if flag == 0:
                res.append(word)
        return res
            
                
            
            
            