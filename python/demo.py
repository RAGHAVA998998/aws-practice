import sys
 
lst = [56, 45, 12, 6]
import numpy as np
arr = np.array(lst)
print(arr.nbytes)
# Output:
# 16 
# print(sys.getsizeof(lst))
# print(sys.getsizeof(arr))
# print(arr.reshape([2,2]))
S_X = np.array([[2, 8, 6, 5],
               [4, 2, 6, 5],
               [4,5,8,1]])
x_cumsum=np.cumsum(S_X,0)
print(x_cumsum)
print(x_cumsum>4)
narr1=np.array([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]).reshape([4,4])
print(narr1)
print(np.arange(11))
ndiaeye1=np.eye(4,4,1) *4
# ndiaeye1>0 if ndiaeye1*5 else ndiaeye1*0
print(ndiaeye1)
narr2=np.diag([4,5,6],1)
m=(narr2>5) & (narr2<10)
print(m)
print(narr2[m])
ndiaeye1[m] *= -1
print(narr1)
print(S_X)
print(S_X[S_X[:,1].sort()])
