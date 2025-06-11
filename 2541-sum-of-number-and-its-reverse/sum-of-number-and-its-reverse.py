class Solution:
    def sumOfNumberAndReverse(self, num: int) -> bool:
        
        for n in range (0,num+1):
            strN = str(n)
            strR = strN[::-1]
            if n + int(strR) == num:
                return True
        return False;    