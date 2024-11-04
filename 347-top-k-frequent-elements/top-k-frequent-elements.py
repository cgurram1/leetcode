class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        mydict = {}
        for val in nums:
            if val not in mydict:
                mydict[val] = 1
            else:
                mydict[val] += 1
        sorted_myDict = dict(sorted(mydict.items(), key = lambda item : item[1], reverse = True))
        result = []
        count = 0
        print(sorted_myDict)
        for key in sorted_myDict:
            if count == k:
                break
            count +=1
            result.append(key)
        return result