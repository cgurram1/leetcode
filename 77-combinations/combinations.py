class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        def myRec(index, arr):
            if len(arr) == k:
                res.append(arr[:])
                return
            if index > n or len(arr) > k:
                return
            arr.append(index)
            myRec(index + 1, arr)
            arr.pop()
            myRec(index + 1, arr)
            return
        res = []
        myRec(1,[])
        return res