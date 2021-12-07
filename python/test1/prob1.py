from scipy.special import comb
import math
c=0
for i in range(0,7):
    c+=(comb(6,i,exact=True)*math.factorial(i))

 

print(c)