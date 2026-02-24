class Solution:
    def isDigitorialPermutation(self, n: int) -> bool:
        def fact(n):
            fac = 1
            for i in range(1,n+1):
                fac *= i
            return fac
        m = {}
        total = 0
        for ch in str(n):
            if ch in m:
                total+=m[ch][1]
                m[ch] = (m[ch][0]+1,m[ch][1])
            else:
                f = fact(int(ch))
                total += f
                m[ch] = (1,f)
        # print(m)
        # print(total)
        for ch in str(total):
            if ch not in m:
                return False
            else:
                if m[ch][0] == 1:
                    m.pop(ch)
                else:
                    m[ch] = (m[ch][0]-1,m[ch][1])
            # print(ch, m)
        if m:
            return False
        return True
