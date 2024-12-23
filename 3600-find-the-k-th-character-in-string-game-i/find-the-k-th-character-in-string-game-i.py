class Solution:
    def kthCharacter(self, k: int) -> str:
        def rec(string):
            if len(string) >= k:
                return string[k-1]
            new_string = ""
            for ch in string:
                if ch != 'z':
                    new_string += chr((ord(ch) + 1))
                else:
                    new_string += 'a'
            return rec(string+new_string)
        return rec("a")

