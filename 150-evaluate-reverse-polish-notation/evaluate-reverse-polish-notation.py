class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if len(tokens) == 1:
            return int(tokens[0])
        stack = []
        stack.append(tokens[0])
        i = 1
        while(True):
            if tokens[i] in ["+","-","*","/"]:
                one = int(stack.pop(-1))
                two = int(stack.pop(-1))
                
                if tokens[i] == "+":
                    stack.append(two + one)
                elif tokens[i] == "-":
                    stack.append(two - one)
                elif tokens[i] == "*":
                    stack.append(one * two)
                else:
                    stack.append(int(two / one))
            else:
                stack.append(tokens[i])
            i+=1
            if len(tokens) == i:
                return stack[0]
