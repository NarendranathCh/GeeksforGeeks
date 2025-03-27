#User function Template for python3
class Solution:
    def missingNumber(self, arr):
        # code here
        n=len(arr)+1
        sum1=(n*(n+1))//2
        sum2=sum(arr)
        return sum1-sum2
            
        

#{ 
 # Driver Code Starts
#Initial Template for Python 3

t = int(input())
for _ in range(0, t):
    arr = list(map(int, input().split()))
    s = Solution().missingNumber(arr)
    print(s)

    print("~")
# } Driver Code Ends