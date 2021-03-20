# K size subsets

def ksizesubsets(s,e,k,l,L):
    if k==0:
        L.append(l)
        return
    for i in range(s,e-k+2):
        temp=l[:]
        temp.append(i)
        ksizesubsets(i+1,e,k-1,temp,L)

n=int(input())
k=int(input())
L=[]
ksizesubsets(1,n,k,[],L)
print(L)
