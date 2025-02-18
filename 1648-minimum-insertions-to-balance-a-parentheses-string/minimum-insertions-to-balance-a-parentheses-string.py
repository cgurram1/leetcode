class Solution:
    def minInsertions(self, s: str) -> int:
        openStack = []
        count = 0
        i = 0
        while i < len(s):
            if s[i] == '(':
                openStack.append(i)
            else:
                # If next character is also ')', it's a valid pair
                if i + 1 < len(s) and s[i + 1] == ')':
                    i += 1  # Skip the next ')'
                else:
                    count += 1  # Need an extra ')'

                if openStack:
                    openStack.pop()
                else:
                    count += 1  # Need an extra '('

            i += 1

        # If there are leftover '(', each requires '))'
        return count + 2 * len(openStack)