class Solution:
    def intToRoman(self, num: int) -> str:
        power = 1
        res = ""
        while(num != 0):
            curr_num = num % 10
            num = num // 10
            if curr_num == 4:
                if power == 1:
                    res = "IV" + res
                if power == 2:
                    res = "XL" + res
                if power == 3:
                    res = "CD" + res
            elif curr_num == 9:
                if power == 1:
                    res = "IX" + res
                if power == 2:
                    res = "XC" + res
                if power == 3:
                    res = "CM" + res
            elif curr_num < 4:
                if power == 1:
                    curr_val = ""
                    for i in range(curr_num):
                        curr_val += "I"
                    res = curr_val + res
                if power == 2:
                    curr_val = ""
                    for i in range(curr_num):
                        curr_val += "X"
                    res = curr_val + res
                if power == 3:
                    curr_val = ""
                    for i in range(curr_num):
                        curr_val += "C"
                    res = curr_val + res
                if power == 4:
                    curr_val = ""
                    for i in range(curr_num):
                        curr_val += "M"
                    res = curr_val + res
            elif curr_num >= 5:
                if power == 1:
                    curr_val = "V"
                    for i in range(curr_num - 5):
                        curr_val += "I"
                    res = curr_val + res
                if power == 2:
                    curr_val = "L"
                    for i in range(curr_num - 5):
                        curr_val += "X"
                    res = curr_val + res
                if power == 3:
                    curr_val = "D"
                    for i in range(curr_num - 5):
                        curr_val += "C"
                    res = curr_val + res
            power+=1
        return res
            

    