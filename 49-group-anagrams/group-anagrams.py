class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dictionary = {}
        for string in strs:
            freqArr = [0] * 26
            for ch in string:
                freqArr[ord(ch) - 97]+=1
            if tuple(freqArr) not in dictionary:
                dictionary[tuple(freqArr)] = [string]
            else:
                dictionary[tuple(freqArr)].append(string)
        result = []
        for key in dictionary:
            result.append(dictionary[key])
        return result