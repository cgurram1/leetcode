class Solution:
    def trimTrailingVowels(self, s: str) -> str:
        res = []
        temp = []
        for ch in s:
            if ch not in ['a','e','i','o','u']:
                res.extend(temp)
                res.append(ch)
                temp = []
            else:
                temp.append(ch)
        return ''.join(res)
        

