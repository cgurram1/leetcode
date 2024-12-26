class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        def invert(string):
            res = ""
            for ch in string:
                if ch == "0":
                    res = res + "1"
                else:
                    res = res + "0"
            return res
        def myRec(n):
            if n == 1:
                return "0"
            string = myRec(n-1)
            return string + "1" + invert(string)[::-1]
        myres = myRec(math.floor(math.log2(k)) + 1)
        # print(myres)
        return myres[k-1]