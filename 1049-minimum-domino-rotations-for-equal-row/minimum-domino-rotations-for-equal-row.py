class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        m = {}
        n = 0
        equals = None
        for i in range(len(tops)):
            if tops[i] != bottoms[i]:
                n+=1
                if (tops[i],'t') not in m:
                    m[(tops[i],'t')]=0
                if (bottoms[i],'b') not in m:
                    m[(bottoms[i],'b')]=0
                m[(tops[i],'t')]+=1
                m[(bottoms[i],'b')]+=1
            else:
                if not equals:
                    equals = tops[i]
                elif tops[i] != equals:
                    return -1
        if n == 0:
            return 0
        # arr = sorted(m.items(),key=lambda x:-x[1])
        res = float('inf')
        for item in m.items():
            if item[1] == n:
                return 0
            if not equals or item[0][0] == equals:
                if item[0][1] == 't':
                    if (item[0][0],'b') in m and m[(item[0][0],'b')] >= n - m[item[0]]:
                        res = min(res, n - m[item[0]])
                else:
                    if (item[0][0],'t') in m and m[(item[0][0],'t')] >= n - m[item[0]]:
                        res = min(res, n - m[item[0]])
        if res == float('inf'):
            return -1
        return res
