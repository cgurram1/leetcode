class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        myDict = {}
        for i in nums:
            if i in myDict:
                myDict[i] = myDict[i] + 1
            else:
                myDict[i] = 1
        sorted_dict_desc = dict(sorted(myDict.items(), key=lambda item: item[1], reverse=True))
        res = []
        count = 0
        for key in sorted_dict_desc:
            if count < k:
                res.append(key)
                count+=1
        return res