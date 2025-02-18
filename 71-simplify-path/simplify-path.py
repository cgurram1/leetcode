class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        i = 0
        if path[-1] != "/":
            path = path + "/"
        while(i < len(path)):
            print(stack)
            if path[i] == '/':
                while(i < len(path) and path[i] == '/'):
                    i+=1
                i-=1
                stack.append('/')
            elif path[i] == '.':
                dotCount = ""
                while(i < len(path)):
                    dotCount += path[i]
                    if path[i] == '/':
                        while(i < len(path) and path[i] == "/"):
                            i+=1
                        i-=1
                        break
                    i+=1
                if dotCount == "./":
                    pass
                elif dotCount == "../":
                    if stack[-1] != "/":
                        stack.pop(-1)
                else:
                    stack.append(dotCount)
            else:
                fileName = ""
                while(i < len(path) and path[i] != '/'):
                    fileName += path[i]
                    i+=1
                while(i < len(path) and path[i] == "/"):
                    i+=1
                i-=1
                stack.append(fileName + "/")
            i+=1
        print(stack)
        res = ''.join(stack)
        if len(res) > 1:
            return res[:-1]
        elif res == "":
            return "/"
        return res
                