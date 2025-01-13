class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        def getIndex(l,r,target):
            while(l < r-1):
                mid = (l + r)//2
                if target == arr[mid]:
                    return [mid]
                elif target > arr[mid]:
                    l = mid
                else:
                    r = mid
            return [l,r]
        ind = getIndex(0,len(arr)-1,x)
        res = []
        if len(ind) == 1:
            res = [arr[ind[0]]]
            k-=1
            l = ind[0]- 1
            r = ind[0] + 1
        else:
            res = []
            l = ind[0]
            r = ind[1]
        while(k>0):
            if l >= 0 and r < len(arr):
                diff1 = x - arr[l]
                diff2 = arr[r] - x
                if diff1 <= diff2:
                    res.append(arr[l])
                    l-=1
                else:
                    res.append(arr[r])
                    r+=1
                k-=1
            elif l < 0:
                k-=1
                res.append(arr[r])
                r+=1
            else:
                k-=1
                res.append(arr[l])
                l-=1
        return sorted(res)
                

