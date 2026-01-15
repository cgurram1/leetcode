class Solution:
    def ambiguousCoordinates(self, s: str):
        def addDot(x):
            res = []

            # no dot case
            if x == "0" or not x.startswith("0"):
                res.append(x)

            # dot cases
            for i in range(1, len(x)):
                left = x[:i]
                right = x[i:]
                if (left == "0" or not left.startswith("0")) and not right.endswith("0"):
                    res.append(left + "." + right)

            return res

        digits = s[1:-1]
        result = []

        for i in range(1, len(digits)):
            part1 = digits[:i]
            part2 = digits[i:]

            l1 = addDot(part1)
            l2 = addDot(part2)

            for x in l1:
                for y in l2:
                    result.append(f"({x}, {y})")

        return result
