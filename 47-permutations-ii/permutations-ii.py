class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def REC(arr,counter):
            if len(arr) == len(nums):
                result.append(arr.copy())
                return
            for num in counter:
                if counter[num] > 0:
                    arr.append(num)
                    counter[num]-=1
                    REC(arr,counter)
                    counter[num]+=1
                    arr.pop()
        counter = Counter(nums)
        result = []
        REC([],counter)
        return result