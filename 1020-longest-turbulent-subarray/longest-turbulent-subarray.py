class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        flag = 1
        count = 1
        res = 0
        for i in range(len(arr)-1):
            if arr[i] > arr[i+1]:
                if flag == 0:
                    count+=1
                else:
                    count = 2
                flag = 1
            elif arr[i] < arr[i+1]:
                if flag == 1:
                    count+=1
                else:
                    count = 2
                flag = 0
            else:
                count = 1
            print(i,count)
            res = max(res,count)
        return max(res,count)
