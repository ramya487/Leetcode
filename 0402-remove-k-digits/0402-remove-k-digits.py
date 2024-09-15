class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        lst = list(num)
        c = 0
        for item in lst:
            while stack != [] and int(stack[-1]) > int(item) and c!= k:
                stack.pop()
                c+=1
            stack.append(item)
        while (c != k and stack != []):
            stack.pop()
            c+=1
        result = ''.join(stack).lstrip('0')

        return result if result else '0'