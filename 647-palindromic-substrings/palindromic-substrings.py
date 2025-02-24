class Solution:
    def countSubstrings(self, s: str) -> int:
        l = 0
        r = 0
        count = 0
        curr = ""
        dummy_str = ""
        for ch in s:
            dummy_str+=(ch + "*")
        dummy_str = dummy_str[:-1]
        print(dummy_str)
        for i in range(len(dummy_str)):
            l = i
            r = i
            while(l >= 0 and r<len(dummy_str)):
                if dummy_str[l] == dummy_str[r]:
                    if dummy_str[l] != "*":
                        count+=1
                else:
                    break
                l-=1
                r+=1
        return count

            
