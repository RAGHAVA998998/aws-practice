import numpy as np
import numpy.linalg as linalg
# arr1=np.arange(16)
# print(arr1)
# arr2=arr1.reshape(4,4)
# print(arr2)
# arr3=np.array([[2,4],[4,2]])
# print(arr3)
# print(linalg.inv(arr3))
a=np.arange(1,31)
a1=a.reshape(6,5)
assert isinstance(a1,np.ndarray)
print(a1)
print(a1[2:4,0:2])
print(a1[0:-2,1:].diagonal())
print(a1[[0,1,3,4],[1,2,3,4]])
print(a1[[0,4,5],-2:])
a2=np.array([5])
a2=a1
